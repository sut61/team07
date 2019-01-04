package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;


@RestController
class PrescriptionController {
    private PrescriptionRepository prescriptionrepository;

    public PrescriptionController(PrescriptionRepository prescriptionrepository) {
        this.prescriptionrepository = prescriptionrepository;
    }

    @GetMapping("/drug-Prescription")
    public Collection<Prescription> coolPre() {
        return prescriptionrepository.findAll().stream().collect(Collectors.toList());
    }

}


