
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

class OrdersController {
    OrdersRepository ordersrepository;
    PartnersRepository partnersrepository;
    CatalogRepository catalogrepository;
       DrugRepository drugrepository;
       StaffRepository staffrepository;
    

    public OrdersController(OrdersRepository ordersrepository, PartnersRepository partnersrepository,
            CatalogRepository catalogrepository, DrugRepository drugrepository, StaffRepository staffrepository) {
        this.ordersrepository = ordersrepository;
        this.partnersrepository = partnersrepository;
        this.catalogrepository = catalogrepository;
        this.drugrepository = drugrepository;
        this.staffrepository = staffrepository;
    } 

    @GetMapping("/Orders-list")
    public Collection<Orders> ordersList() {
        return ordersrepository.findAll().stream().collect(Collectors.toList());

    }

    @GetMapping("/OrdersName/{name}")
    public Orders Ordersname(@PathVariable("name") String name) {
        return ordersrepository.findByname(name);
    }

    @PostMapping("/Orders-insert/nameorders/{nameorders}/partnersId/{partnersId}/catalogId/{catalogId}/drugId/{drugId}/staff/{staff}/amount/{amount}")
    public ResponseEntity<Map<String, Object>> Orderssumbit(@PathVariable("nameorders") String nameorders,
            @PathVariable("partnersId") Long partnersId, @PathVariable("catalogId") Long catalogId,@PathVariable("drugId") Long drugId,@PathVariable("staff") String staff,
            @PathVariable("amount") Integer amount) {

        Orders O = this.ordersrepository.findByname(nameorders);
        if (O == null) {
            try {

                Partners P = this.partnersrepository.findBypartnersId(partnersId);
                Catalog C = this.catalogrepository.findByCatalogId(catalogId);
                Drug D = this.drugrepository.findByDrugId(drugId);
    
                Staff S = this.staffrepository.findByStaffUser(staff);
     

                this.ordersrepository.save(new Orders(nameorders, amount, P, C,D,S));

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

        } else {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", false);
            json.put("status", "หมายเลขรายการนำเข้ายาซ้ำซ้อน กรุณากรอกข้อมูลใหม่");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "404");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));

        }

    }

}
