<<<<<<< HEAD
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

    @GetMapping("/Stroage-prescription")
    public Collection<Prescription> prescriptions() {
        return prescriptionrepository.findAll().stream().collect(Collectors.toList());
    }

}


=======
/*package SUT.SE61.Team07.Controller;

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

    @GetMapping("/Stroage-prescription")
    public Collection<Prescription> prescriptions() {
        return prescriptionrepository.findAll().stream().collect(Collectors.toList());
    }

}
*/

>>>>>>> 9edd6444efd25d3d4e5e4ab5e3e846b2f799aeec
