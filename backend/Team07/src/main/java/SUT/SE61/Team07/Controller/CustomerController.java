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
    private  CustomerRepository customerRepository;
    @Autowired
    private  InitialRepository initialRepository;
    @Autowired
    private  GenderRepository genderRepository;
    @Autowired
    private  BloodTypeRepository bloodTypeRepository;

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
}
    // @RequestBody Customer newCustomer,
  /*  @PostMapping("/Customer/{initial}/{name}/{gender}/{blood}/{address}/{phonenumber}/{username}/{password}")
    public Customer newCustomer(
                                @PathVariable String initial,
                                @PathVariable String name,
                                @PathVariable String gender,
                                @PathVariable String blood,
                                @PathVariable String address,
                                @PathVariable String phonenumber, 
                                @PathVariable String username,
                                @PathVariable String password                 
    ){
        Customer newCustomer = new Customer();
        Initial initialCustomer = initialRepository.findByInitialName(initial); //การที่มีselectข้อมูล
        Gender gen = genderRepository.findBySex(gender); //การที่มีselectข้อมูล
        BloodType bloods = bloodTypeRepository.findByBloodTypeName(blood); //การที่มีselectข้อมูล

        newCustomer.setInitial(initialCustomer);
        newCustomer.setCustomerName(name);
        newCustomer.setGender(gen);
        newCustomer.setBloodType(bloods);
        newCustomer.setCustomerAddress(address);
        newCustomer.setCustomerPhone(phonenumber);
        newCustomer.setCustomerUserID(username);
        newCustomer.setCustomerPassword(password);

        return customerRepository.save(newCustomer);

    }

    @PostMapping("/Customer/customeruserID/{customeruserID}/customerPassword/{customerPassword}")
    public ResponseEntity<Map<String, Object>> customercheck(@PathVariable("customeruserID") String customeruserID,
            @PathVariable("customerPassword") String customerPassword) {
                Customer customer = this.customerRepository.findBycustomerUserID(customeruserID);
                Customer customer2 = this.customerRepository.findBycustomerPassword(customerPassword);
    
            }
        }*/

