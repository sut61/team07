package SUT.SE61.Team07.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import SUT.SE61.Team07.Entity.*;

 @RepositoryRestResource
 public interface GenderRepository extends JpaRepository<Gender, Long> {
     Gender findByGenderId(Long genderId);
     Gender findBySex(String sex);
 }