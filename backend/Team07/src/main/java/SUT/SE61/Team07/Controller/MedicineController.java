
package SUT.SE61.Team07.Controller;

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

class MedicineController {
    private MedicineRepository medicinerepository;

    public MedicineController(MedicineRepository medicinerepository) {
        this.medicinerepository = medicinerepository;
    }

    @GetMapping("/Medicine")
    public Collection<Medicine> Medicine() {
        return medicinerepository.findAll();
    }


   

    @PostMapping("/Medicine-insert/name/{name}")
    public ResponseEntity<Map<String, Object>> Medicinesumbit(@PathVariable("name") String name) {
        try {
            Medicine Me = new Medicine(name);
            this.medicinerepository.save(Me);
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
  // ไว้เพิ่มยาเข้าคลัง 
// @PostMapping("/Drug-insert/{id}/name/{name}")
// public ResponseEntity<Map<String, Object>> Drugsumbit(@PathVariable("id")
// Long id,
// @PathVariable("name") String name) {
// try{
// Drug d = new Drug(name);
// this.drugrepository.save(d);
// Map<String, Object> json = new HashMap<String, Object>();
// json.put("success", true);
// json.put("status", "save");

// HttpHeaders headers = new HttpHeaders();
// headers.add("Content-Type", "application/json; charset=UTF-8");
// headers.add("X-Fsl-Location", "/");
// headers.add("X-Fsl-Response-Code", "302");
// return (new ResponseEntity<Map<String, Object>>(json, headers,
// HttpStatus.OK));
// }catch (NullPointerException e) {
// Map<String, Object> json = new HashMap<String, Object>();
// System.out.println("Error Save CancelReservation");
// json.put("success", false);
// json.put("status", "save-false");

// HttpHeaders headers = new HttpHeaders();
// headers.add("Content-Type", "application/json; charset=UTF-8");
// headers.add("X-Fsl-Location", "/");
// headers.add("X-Fsl-Response-Code", "500");
// return (new ResponseEntity<Map<String, Object>>(json, headers,
// HttpStatus.INTERNAL_SERVER_ERROR));

// }
// }