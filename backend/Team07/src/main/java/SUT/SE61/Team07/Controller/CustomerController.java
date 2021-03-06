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

class CustomerController {
    private CustomerRepository customerrepository;
    private InitialRepository initialrepository;
    private GenderRepository genderrepository;
    private BloodTypeRepository bloodTyperepository;

    public CustomerController(CustomerRepository customerrepository, InitialRepository initialrepository,
            GenderRepository genderrepository, BloodTypeRepository bloodTyperepository) {
        this.customerrepository = customerrepository;
        this.initialrepository = initialrepository;
        this.genderrepository = genderrepository;
        this.bloodTyperepository = bloodTyperepository;
    }

    @GetMapping("/Customer-list")
    public Collection<Customer> Customer() {
        return customerrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Customer/{customerId}")
    public Customer customerFind(@PathVariable("customerId") Long id) {
        return customerrepository.findByCustomerId(id);
    }

 
    @GetMapping("/Customer/customerName/{customerName}")
    public Customer customerusername(@PathVariable("customerName") String customerName) {
        return customerrepository.findBycustomerName(customerName);
    }



    @PostMapping("/Customer-insert/InitalId/{InitalId}/Name/{Name}/GenderId/{GenderId}/BloodType/{BloodType}/Allergic/{Allergic}/Address/{Address}/Phonenumber/{Phonenumber}")
    public ResponseEntity<Map<String, Object>> cussumbit(@PathVariable("InitalId") Long InitalId,
            @PathVariable("Name") String Name, @PathVariable("GenderId") Long GenderId,
            @PathVariable("BloodType") Long BloodType,@PathVariable("Allergic") String Allergic,
            @PathVariable("Address") String Address,@PathVariable("Phonenumber") String Phonenumber) {

        try {

            Initial I = this.initialrepository.findByInitialId(InitalId); // Select
            Gender G = this.genderrepository.findByGenderId(GenderId); // Select
            BloodType B = this.bloodTyperepository.findByBloodTypeId(BloodType);// Select

            this.customerrepository.save(new Customer(I, Name, G, B, Allergic,Address, Phonenumber));

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
