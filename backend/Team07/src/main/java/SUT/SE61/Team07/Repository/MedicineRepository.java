package SUT.SE61.Team07.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import SUT.SE61.Team07.Entity.*;

@RepositoryRestResource
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
public
interface MedicineRepository extends JpaRepository<Medicine, Long> {

	Medicine findBymedicineId(Long medicineId);
	Medicine findByName(String name);
}
