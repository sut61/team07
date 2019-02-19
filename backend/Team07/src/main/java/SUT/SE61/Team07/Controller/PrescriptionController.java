
package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class PrescriptionController {
    private PrescriptionRepository prescriptionrepository;
    private DrugRepository drugrepository;
    private StaffRepository staffrepository;
    private CategoryRepository categoryrepository;

    public PrescriptionController(PrescriptionRepository prescriptionrepository, DrugRepository drugrepository,
            StaffRepository staffrepository, CategoryRepository categoryrepository) {
        this.prescriptionrepository = prescriptionrepository;
        this.drugrepository = drugrepository;
        this.staffrepository = staffrepository;
        this.categoryrepository = categoryrepository;
    }

    @GetMapping("/Stroage-prescription")
    public Collection<Prescription> prescriptions() {
        return prescriptionrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/nameprescription/{nameprescription}")
    public Prescription Prescriptionnames(@PathVariable("namepre") String namepre) {
        return prescriptionrepository.findByNamepre(namepre);
    }

    @PostMapping("/Prescription-insert/nameprescription/{nameprescription}/amountout/{amountout}/CategoryId/{CategoryId}/DrugId/{DrugId}/staff/{staff}")
    public ResponseEntity<Map<String, Object>> Drugsumbit(@PathVariable("nameprescription") String nameprescription,
            @PathVariable("amountout") String amountout, @PathVariable("CategoryId") Long CategoryId,
            @PathVariable("DrugId") Long DrugId, @PathVariable("staff") String staff) {

        Prescription P = this.prescriptionrepository.findByNamepre(nameprescription);
        if (P != null) {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", false);
            json.put("status", "save-false");
            json.put("statuss", "ข้อมูลหมายเลขใบสั่งยาซ้ำกัน กรุณากรอกใหม่อีกครั้ง");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));

        } else {
            try {

                Staff S = this.staffrepository.findByStaffUser(staff);
                Drug D = this.drugrepository.findByDrugId(DrugId);
                Category C = this.categoryrepository.findByCategoryId(CategoryId);

                System.out.println("==============================");

                System.out.println("staff----");
                System.out.println(staff);
                System.out.println("staff----");
                System.out.println(DrugId);
                System.out.println(amountout);
                System.out.println(nameprescription);

                System.out.println("==============================");

                this.prescriptionrepository.save(new Prescription(nameprescription, amountout, C, D, S));

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

}
