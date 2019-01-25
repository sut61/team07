package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InitialRepository initialRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private BloodTypeRepository bloodTypeRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/Customer-list")
    public Collection<Customer> Customer() {
        return customerRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Customer/{customerId}")
    public Customer customerFind(@PathVariable("customerId") Long id) {
        return customerRepository.findByCustomerId(id);
    }

    @GetMapping("/Customer/customeruserID/{customeruserID}")
    public Customer customeruser(@PathVariable("customeruserID") String name) {
        return customerRepository.findBycustomerUserID(name);
    }

    @GetMapping("/Customer/customerPassword/{customerPassword}")
    public Customer customerpassword(@PathVariable("customerPassword") String password) {
        return customerRepository.findBycustomerPassword(password);
    }

    @PostMapping("/Customer/customeruserID/{customeruserID}/customerPassword/{customerPassword}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Object>> customercheck(@PathVariable("customeruserID") String customeruserID,
            @PathVariable("customerPassword") String customerPassword) {
        Customer cusUID = this.customerRepository.findBycustomerUserID(customeruserID);
        Customer cuspasswd = this.customerRepository.findBycustomerPassword(customerPassword);

        if ((cusUID != null) && (cuspasswd != null)) {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "found");
            json.put("user", cusUID);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        } else {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", false);
            json.put("status", "not found");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "404");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        }

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/Customer-insert/initalId/{initalId}/genderId/{genderId}/bloodTypeId/{bloodTypeId}/name/{name}/address/{address}/phonenumber/{phonenumber}/username/{username}/password/{password}")
    public ResponseEntity<Map<String, Object>> Customersumbit(@PathVariable("initalId") Long initalId,
            @PathVariable("genderId") Long genderId, @PathVariable("bloodTypeId") Long bloodTypeId,
            @PathVariable("names") String names, @PathVariable("address") String address,
            @PathVariable("phonenumber") String phonenumber, @PathVariable(" username") String username,
            @PathVariable(" password") String password) {

        try {

            Initial I = this.initialRepository.findByInitialId(initalId); //Select
            Gender G = this.genderRepository.findByGenderId(genderId); //Select
            BloodType B = this.bloodTypeRepository.findByBloodTypeId(bloodTypeId);

            this.customerRepository.save(new Customer(I, names, G, B, address, phonenumber, username, password));

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


