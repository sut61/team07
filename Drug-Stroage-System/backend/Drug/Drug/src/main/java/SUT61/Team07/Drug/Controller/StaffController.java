package SUT61.Team07.Drug.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SUT61.Team07.Drug.Entity.Staff;
import SUT61.Team07.Drug.Repository.StaffRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolStaffController {

    private StaffRepository staffRepository;


    public CoolStaffController(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

   

}
