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
 class WorktimeController {
    
        @Autowired
       WorktimeRepository worktimerepository;

     public WorktimeController(WorktimeRepository worktimerepository) {
        this.worktimerepository = worktimerepository;
    }

    @GetMapping("/Worktime-list")
    public Collection<Worktime> worktimeList() {
        return worktimerepository.findAll().stream().collect(Collectors.toList());
   }
 }