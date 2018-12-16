package SUT61.Team07.Drug.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SUT61.Team07.Drug.Entity.Prescription;
import SUT61.Team07.Drug.Repository.PrescriptionRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolPrescriptionController {

    private PrescriptionRepository prescriptionRepository;


    public CoolPrescriptionController(PrescriptionRepository prescriptionRepository) {
        this.prescriptionRepository = prescriptionRepository;
    }

   

}
