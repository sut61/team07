package SUT.SE61.Team07.Controller;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;


@RestController
 @CrossOrigin(origins = "http://localhost:4200")
 class ShowHrsController {
    
     
        private ShowHrsRepository showHrsRepository;
       
        
        
     public ShowHrsController(ShowHrsRepository showHrsRepository) {
        this.showHrsRepository = showHrsRepository;
    }
    @GetMapping("/ShowHrs-list")
    public Collection<ShowHrs>showHrsList() {
        return showHrsRepository.findAll().stream().collect(Collectors.toList());
   }
//    @PostMapping("ShowHrs/{staff}/{staffName}/{price}/{pricerange}/{detailsDescription}/{categoryName}")
//     public ShowHrs newShowHrs(@RequestBody ShowHrs newShowHrs,
//                                 @PathVariable String staff,
//                                 @PathVariable String staffName,
//                                 @PathVariable Integer time,
//                                 @PathVariable String timerange,
//                                 @PathVariable String detailsDescription,
//                                 @PathVariable String departmentName                
//     ){
//         Customer customers = customerRepository.findByCustomerName(customer);
//         Category categoryDetails = categoryRepository.findBycategoryName(categoryName); //การที่มีselectข้อมูล
//         PriceRange priceRange = priceRangeRepository.findByPrice(pricerange);
    
//         newDetails.setCustomer(customers);
//         newDetails.setDetailsName(detailsName);
//         newDetails.setPrices(price);
//         newDetails.setPriceRange(priceRange);//select
//         newDetails.setDetailsDescription(detailsDescription);
//         newDetails.setCategory(categoryDetails);// select
//         newDetails.setDate(new Date());
        
//         return detailsrepository.save(newDetails);
//     }
 }
