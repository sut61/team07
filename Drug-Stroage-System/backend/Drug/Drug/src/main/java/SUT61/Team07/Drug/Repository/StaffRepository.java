package SUT61.Team07.Drug.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import SUT61.Team07.Drug.Entity.Staff;

@RepositoryRestResource
interface StaffRepository extends JpaRepository<Staff, Long> {
}