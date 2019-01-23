package SUT.SE61.Team07.Controller;


import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class BloodTypeController {
    BloodTypeRepository bloodTyperepository;

    public BloodTypeController(BloodTypeRepository bloodTyperepository) {
        this.bloodTyperepository = bloodTyperepository;
    }

    @GetMapping("/BloodType-list")
    public Collection<BloodType> bloodTypeList() {
        return bloodTyperepository.findAll().stream().collect(Collectors.toList());

    }

}
