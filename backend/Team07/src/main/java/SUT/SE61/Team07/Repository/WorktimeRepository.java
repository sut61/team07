package SUT.SE61.Team07.Repository;
import SUT.SE61.Team07.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface WorktimeRepository extends JpaRepository<Worktime, Long> {
	Worktime findBytimeId(Long timeId);
}