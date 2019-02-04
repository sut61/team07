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

class NotificationDateController {
    NotificationDateRepository notificationDaterepository;

    public NotificationDateController(NotificationDateRepository notificationDaterepository) {
        this.notificationDaterepository = notificationDaterepository;
    }

    @GetMapping("/NotificationDate-list")
    public Collection<NotificationDate> notificationDatelist() {
        return notificationDaterepository.findAll().stream().collect(Collectors.toList());

    }

}
