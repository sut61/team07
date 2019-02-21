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

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class StaffController {
    private StaffRepository staffrepository;

    public StaffController(StaffRepository staffrepository) {
        this.staffrepository = staffrepository;
    }

    @GetMapping("/Staff-list")
    public Collection<Staff> staffs() {
        return staffrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Staff/{staffId}")
    public Staff staffFind(@PathVariable("staffId") Long id) {
        return staffrepository.findByStaffId(id);
    }

    @GetMapping("/Staffuser/{staffUser}")
    public Staff staffuser(@PathVariable("staffUser") String staffUser) {
        return staffrepository.findByStaffUser(staffUser);
    }

    @GetMapping("/staffpassword/{staffPass}")
    public Staff staffpassword(@PathVariable("staffPass") String staffPass) {
        return staffrepository.findByStaffPass(staffPass);
    }

    @GetMapping("/StaffOnline/{status}")
    public Staff staffonline(@PathVariable("status")String status){
        return staffrepository.findByOnline(status);
    }
    

    @PostMapping("/Staff/Staffuser/{staffUser}/staffpassword/{staffPass}")
    public ResponseEntity<Map<String, Object>> staffcheck(@PathVariable("staffUser") String staffUser,
            @PathVariable("staffPass") String staffPass) {
        Staff staffuser = this.staffrepository.findByStaffUser(staffUser);
        Staff staffpass = this.staffrepository.findByStaffPass(staffPass);

        if ((staffuser != null) && (staffpass != null)) {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "found");
            json.put("user", staffuser);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        } else {
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

    @PostMapping("/Staff/StaffOnline/{onlineId}/staffName/{staffName}/staffUser/{staffUser}/staffPass/{staffPass}/staffPhone/{staffPhone}")
    public ResponseEntity<Map<String, Object>> setStaffOnline(@PathVariable("onlineId") Long onlineId,
            @PathVariable("staffName") String staffName, @PathVariable("staffUser") String staffUser,
            @PathVariable("staffPass") String staffPass, @PathVariable("staffPhone") String staffPhone) {

        System.out.println("=============stafflogin=================");

        System.out.println(onlineId);
        System.out.println(staffName);
        System.out.println(staffUser);
        System.out.println(staffPass);
        System.out.println(staffPhone);

        System.out.println("================stafflogin==============");
        Staff staff = this.staffrepository.findByStaffId(onlineId);
        if (staff != null) {

            staff.setStaffId(onlineId);
            staff.setStaffName(staffName);
            staff.setStaffUser(staffUser);
            staff.setStaffPass(staffPass);
            staff.setStaffPhone(staffPhone);
            staff.setOnline("true");
            
            this.staffrepository.save(staff);

            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "found");
            json.put("user", staff);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        } else {
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

    @PostMapping("/Staff/StaffOffline/{onlineId}")
    public ResponseEntity<Map<String, Object>> setStaffOffline(@PathVariable("onlineId") Long onlineId) {
        Staff staff = this.staffrepository.findByStaffId(onlineId);

        if (staff != null) {

            staff.setStaffId(onlineId);
            staff.setOnline("false");
            this.staffrepository.save(staff);

            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "found");
            json.put("user", staff);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        } else {
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
