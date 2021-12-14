package com.example.spring_jpa_gradle.controller;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.data.Team;
import com.example.spring_jpa_gradle.service.IPersonService;
import com.example.spring_jpa_gradle.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
//@RequestMapping("person")
public class HelloBean {

    private final IPersonService personService;
    private final ITeamService teamService;

    @Autowired
    public HelloBean(IPersonService userService, ITeamService teamService) {
        this.personService = userService;
        this.teamService = teamService;
    }

    @CrossOrigin
    @GetMapping("/people/{id}")
    ResponseEntity<String> one(@PathVariable Long id) {
        return new ResponseEntity<String>(personService.findByPersonId(id).toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/best")
    ResponseEntity<String> best() {
        return new ResponseEntity<String>(personService.getBestPlayers().toString(), HttpStatus.OK);
        //return new ResponseEntity<String>(personService.findByPersonId(1).toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/teams")
    public ResponseEntity<String> teams() {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"teams\": [");
        boolean first = true;
        for (Team el : teamService.getAll()) {
            if (first) {
                first = false;
            } else {
                sb.append(",");
            }
            sb.append(el);
        }
        sb.append("]}");
        return new ResponseEntity<String>(sb.toString(), HttpStatus.OK);
        //return new ResponseEntity<String>(personService.findByPersonId(1).toString(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/shit")
    String shit() {return "shit_2";}

    //@GetMapping("/people")
    //Iterable<Person> all() {
    //    return personService.findByLastName;
    //}

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value="myName", defaultValue="World") String name){
        return String.format("Hello %s!", name);
    }
    @GetMapping("/bye")
    public String sayBye(@RequestParam(value="myName", defaultValue="Cruel World") String name){
        return String.format("Bye %s!", name);
    }

}
