package SUT.SE61.Team07.Controller;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

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

class NotificationController {
    NotificationRepository notificationrepository;
    CustomerRepository customerrepository;
    DrugRepository drugrepository;
    TimeEatRepository timeEatrepository;

    public NotificationController(NotificationRepository notificationrepository, CustomerRepository customerrepository,
            DrugRepository drugrepository, TimeEatRepository timeEatrepository) {
        this.notificationrepository = notificationrepository;
        this.customerrepository = customerrepository;
        this.drugrepository = drugrepository;
        this.timeEatrepository = timeEatrepository;
    }

    @GetMapping("/Notification-list")
    public Collection<Notification> Notificationlist() {
        return notificationrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/NotificationName/{name}")
    public Notification notificationname(@PathVariable("notificationName") String notificationName) {
        return notificationrepository.findByNotificationName(notificationName);
    }

    @PostMapping("/Notification-insert/customerId/{customerId}/drugId/{drugId}/timeEatId/{timeEatId}/notificationName/{notificationName}")
    public ResponseEntity<Map<String, Object>> Orderssumbit(@PathVariable("customerId") Long customerId,
            @PathVariable("drugId") Long drugId, @PathVariable("timeEatId") Long timeEatId,
            @PathVariable("notificationName") String notificationName) {
        try {
            Customer C = this.customerrepository.findByCustomerId(customerId);
            Drug D = this.drugrepository.findByDrugId(drugId);
            TimeEat T = this.timeEatrepository.findByTimeEatId(timeEatId);

            this.notificationrepository.save(new Notification(notificationName, C, D, T));

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