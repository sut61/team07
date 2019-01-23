package SUT.SE61.Team07.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import SUT.SE61.Team07.Entity.*;
@RepositoryRestResource
//@CrossOrigin(origins = "http://localhost:4200")
public interface InitialRepository extends JpaRepository<Initial, Long> {
   Initial findByInitialId(Long initialId);
   Initial findByName(String name);

}