package SUT.SE61.Team07.Controller;

import SUT.SE61.Team07.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;


@RestController
 @CrossOrigin(origins = "http://localhost:4200")
 class ShowHrsController {
    
     
   @Autowired     
   private ShowHrsRepository showHrsRepository;
   @Autowired     
   private StaffRepository staffRepository;
   @Autowired     
   private DepartmentRepository departmentRepository;
   @Autowired     
   private WorktimeRepository worktimeRepository;
       
        
        
     public ShowHrsController(ShowHrsRepository showHrsRepository) {
        this.showHrsRepository = showHrsRepository;
    }
    @GetMapping("/ShowHrs-list")
    public Collection<ShowHrs>showHrsList() {
        return showHrsRepository.findAll().stream().collect(Collectors.toList());
   }
   @PostMapping("ShowHrs-insert/staff/{staffId}/department/{deptId}/worktime/{timeId}")
    public ResponseEntity<Map<String,Object>> ShowHrssubmit(@PathVariable ("staffId") Long staffId,
            @PathVariable ("deptId") Long deptId, 
            @PathVariable ("timeId") Long timeId  ){             
    
      try {
         Staff S = this.staffRepository.findByStaffId(staffId);
         Department D = this.departmentRepository.findBydeptId(deptId);
         Worktime W = this.worktimeRepository.findBytimeId(timeId);

         this.showHrsRepository.save(new ShowHrs(S, D, W));

         Map<String, Object> json = new HashMap<String, Object>();
         json.put("success", true);
         json.put("status", "save");

         HttpHeaders headers = new HttpHeaders();
         headers.add("Content-Type", "application/json; charset=UTF-8");
         headers.add("X-Fsl-Location", "/");
         headers.add("X-Fsl-Response-Code", "302");
         return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
     } catch (NullPointerException e) {
         Map<String, Object> json = new HashMap<String, Object>();
         System.out.println("Error Save CancelReservation");
         json.put("success", false);
         json.put("status", "save-false");

         HttpHeaders headers = new HttpHeaders();
         headers.add("Content-Type", "application/json; charset=UTF-8");
         headers.add("X-Fsl-Location", "/");
         headers.add("X-Fsl-Response-Code", "500");
         return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.INTERNAL_SERVER_ERROR));

     }
    }
 }