package SUT.SE61.Team07.Controller;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

class StaffController {
    private StaffRepository staffrepository;

    public StaffController(StaffRepository staffrepository) {
        this.staffrepository = staffrepository;
    }

    @GetMapping("/Staff-list")
    public Collection<Staff> staffs() {
        return staffrepository.findAll().stream().collect(Collectors.toList());
    }

    
    @GetMapping("/Staffuser/{staffUser}")
     public Staff staffuser(@PathVariable("staffUser")String staffUser){
         return staffrepository.findByStaffUser(staffUser);
     }
    
     @GetMapping("/staffpassword/{staffPass}")
     public Staff staffpassword(@PathVariable("staffPass")String staffPass){
         return staffrepository.findByStaffPass(staffPass);
     }


    @PostMapping("/Staff/Staffuser/{staffUser}/staffpassword/{staffPass}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Object>> staffcheck(@PathVariable("staffUser") String staffUser,
            @PathVariable("staffPass") String staffPass) {
                Staff staffuser = this.staffrepository.findByStaffUser(staffUser);
                Staff staffpass = this.staffrepository.findByStaffPass(staffPass);

                if((staffuser != null ) && (staffpass != null)){
                    Map<String, Object> json = new HashMap<String, Object>();
                    json.put("success", true);
                    json.put("status", "found");
                    json.put("user",staffuser);
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Content-Type", "application/json; charset=UTF-8");
                    headers.add("X-Fsl-Location", "/");
                    headers.add("X-Fsl-Response-Code", "302");
                    return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
                }else{
                    Map<String, Object> json = new HashMap<String, Object>();
                    json.put("success", false);
                    json.put("status", "not found");
        
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Content-Type", "application/json; charset=UTF-8");
                    headers.add("X-Fsl-Location", "/");
                    headers.add("X-Fsl-Response-Code", "404");
                    return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
                }
    
            }
    
}


