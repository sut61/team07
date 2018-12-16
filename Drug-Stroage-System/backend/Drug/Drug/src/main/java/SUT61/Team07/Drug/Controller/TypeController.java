package SUT61.Team07.Drug.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SUT61.Team07.Drug.Entity.Type;
import SUT61.Team07.Drug.Repository.TypeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolTypeController {

    private TypeRepository typeRepository;


    public CoolTypeController(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

   

}
