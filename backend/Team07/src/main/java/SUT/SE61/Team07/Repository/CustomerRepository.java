package SUT.SE61.Team07.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import SUT.SE61.Team07.Entity.*;

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Customer findByCustomerId(Long customerId);
	Customer findBycustomerUserID(String  customeruserID);
	Customer findBycustomerPassword(String  customerPassword);
	Customer findBycustomerName(String  customerName);
	
} 