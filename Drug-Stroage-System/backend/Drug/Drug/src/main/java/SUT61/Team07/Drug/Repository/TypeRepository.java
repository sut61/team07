package SUT61.Team07.Drug.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import SUT61.Team07.Drug.Entity.Type;

@RepositoryRestResource
interface TypeRepository extends JpaRepository<Type, Long> {


}