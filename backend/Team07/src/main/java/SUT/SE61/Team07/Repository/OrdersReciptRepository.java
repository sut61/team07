package SUT.SE61.Team07.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import SUT.SE61.Team07.Entity.*;
@RepositoryRestResource
@CrossOrigin("http://localhost:4200")
public interface OrdersReciptRepository extends JpaRepository<Orders, Long> {
    
}