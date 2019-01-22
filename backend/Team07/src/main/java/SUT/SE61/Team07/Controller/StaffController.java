package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;


@RestController
class StaffController {
    private StaffRepository staffrepository;

    public StaffController(StaffRepository staffrepository) {
        this.staffrepository = staffrepository;
    }

    @GetMapping("/Stroage-staff")
    public Collection<Staff> staffs() {
        return staffrepository.findAll().stream().collect(Collectors.toList());
    }
}

