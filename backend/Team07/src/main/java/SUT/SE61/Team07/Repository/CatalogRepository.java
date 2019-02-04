package SUT.SE61.Team07.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import SUT.SE61.Team07.Entity.*;

@RepositoryRestResource
public interface CatalogRepository extends JpaRepository<Catalog, Long> {
    Catalog findByCatalogId(Long catalogId);
}
