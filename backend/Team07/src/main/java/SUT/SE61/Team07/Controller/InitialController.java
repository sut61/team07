package SUT.SE61.Team07.Controller;


import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class InitialController {

  
    private  InitialRepository initialRepository;

    public InitialController(InitialRepository initialRepository) {
        this.initialRepository = initialRepository;
    }

    @GetMapping("/Initial-list")
    public Collection<Initial> initial() {
        return initialRepository.findAll().stream().collect(Collectors.toList());
    }

}