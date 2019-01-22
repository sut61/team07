/*package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;


@RestController
class TypeController {
    private TypeRepository typerepository;

    public TypeController(TypeRepository typerepository) {
        this.typerepository = typerepository;
    }
    @GetMapping("/Stroage-type")
    public Collection<Type> types() {
        return typerepository.findAll().stream().collect(Collectors.toList());
    }
}
*/

