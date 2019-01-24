package SUT.SE61.Team07.Controller;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

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

                if((cusUID != null ) && (cuspasswd != null)){
                    Map<String, Object> json = new HashMap<String, Object>();
                    json.put("success", true);
                    json.put("status", "found");
                    json.put("user",cusUID);
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Content-Type", "application/json; charset=UTF-8");
                    headers.add("X-Fsl-Location", "/");
                    headers.add("X-Fsl-Response-Code", "302");
                    return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
                }else{
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
           /* @PostMapping("/Customer/{initial}/{name}/{gender}/{blood}/{address}/{phonenumber}/{username}/{password}")
            @CrossOrigin(origins = "http://localhost:4200")
            public ResponseEntity<Map<String, Object>> userSumbit(@PathVariable("id") Long customerId,
                        @PathVariable("initial") String initial, @PathVariable("name")  String name, 
                        @PathVariable("gender") String gender, @PathVariable("blood") String blood, 
                        @PathVariable("address") String address , @PathVariable("phonenumber") String phonenumber, 
                        @PathVariable(" username")  String username, @PathVariable(" password")  String password) {

                
                try {

                    Customer cus = new Customer(initial, name, gender,blood,address,phonenumber,username,password);

                    this.customerRepository.save(cus);

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



            }*/
}          


// @RequestBody Customer newCustomer,
/*
 * @PostMapping(
 * "/Customer/{initial}/{name}/{gender}/{blood}/{address}/{phonenumber}/{username}/{password}")
 * public Customer newCustomer(
 * 
 * @PathVariable String initial,
 * 
 * @PathVariable String name,
 * 
 * @PathVariable String gender,
 * 
 * @PathVariable String blood,
 * 
 * @PathVariable String address,
 * 
 * @PathVariable String phonenumber,
 * 
 * @PathVariable String username,
 * 
 * @PathVariable String password ){ Customer newCustomer = new Customer();
 * Initial initialCustomer = initialRepository.findByInitialName(initial);
 * //การที่มีselectข้อมูล Gender gen = genderRepository.findBySex(gender);
 * //การที่มีselectข้อมูล BloodType bloods =
 * bloodTypeRepository.findByBloodTypeName(blood); //การที่มีselectข้อมูล
 * 
 * newCustomer.setInitial(initialCustomer); newCustomer.setCustomerName(name);
 * newCustomer.setGender(gen); newCustomer.setBloodType(bloods);
 * newCustomer.setCustomerAddress(address);
 * newCustomer.setCustomerPhone(phonenumber);
 * newCustomer.setCustomerUserID(username);
 * newCustomer.setCustomerPassword(password);
 * 
 * return customerRepository.save(newCustomer);
 * 
 * }
 * 
 * @PostMapping(
 * "/Customer/customeruserID/{customeruserID}/customerPassword/{customerPassword}")
 * public ResponseEntity<Map<String, Object>>
 * customercheck(@PathVariable("customeruserID") String customeruserID,
 * 
 * @PathVariable("customerPassword") String customerPassword) { Customer
 * customer = this.customerRepository.findBycustomerUserID(customeruserID);
 * Customer customer2 =
 * this.customerRepository.findBycustomerPassword(customerPassword);
 * 
 * } }
 */
