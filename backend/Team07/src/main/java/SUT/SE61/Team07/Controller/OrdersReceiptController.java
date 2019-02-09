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

class OrdersReceiptController {
    private OrdersReciptRepository orderreceiptrepository;

    public OrdersReceiptController(OrdersReciptRepository orderreceiptrepository) {
        this.orderreceiptrepository = orderreceiptrepository;
    }

    @GetMapping("/OrderRecipt-list")
    public Collection<OrdersReceipt> OrderRecipts() {
        return orderreceiptrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/OrderRecipt/{OrderReciptId}")
    public OrdersReceipt OrderReciptFindss(@PathVariable("OrderReciptId") Long OrderReciptId) {
        return orderreceiptrepository.findByordersreceiptId(OrderReciptId);
    }

    @PostMapping("/OrderRecipt-insert/amount/{amount}")
    public ResponseEntity<Map<String, Object>> OrderReciptsumbit(@PathVariable("amount") Integer amount) {
        try {


            this.orderreceiptrepository.save(new OrdersReceipt(amount));
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