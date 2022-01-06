package com.example.spring_jpa_gradle.controller;

import com.example.spring_jpa_gradle.service.ILoaderService;
import com.example.spring_jpa_gradle.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoaderBean {

    private final ILoaderService loaderService;
    private final ITeamService teamService;

    @Autowired
    public LoaderBean(ILoaderService loaderService, ITeamService teamService) {
        this.loaderService = loaderService;
        this.teamService = teamService;
    }

    @CrossOrigin
    @GetMapping("/load/teams")
    ResponseEntity<String> load_all(@RequestParam Long number) {
        long teams_before = teamService.count();
        loaderService.loadTeams(number);
        long teams_after = teamService.count();
        if (teams_after == teams_before + number) {
            return new ResponseEntity<String>(number + " teams loaded.", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Teams loading failed, " + (teams_after - teams_before) + "loaded.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
