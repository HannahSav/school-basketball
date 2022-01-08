package com.example.spring_jpa_gradle.controller;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.data.Team;
import com.example.spring_jpa_gradle.iowrapper.ITeamCard;
import com.example.spring_jpa_gradle.iowrapper.PlayersByTeamCard;
import com.example.spring_jpa_gradle.iowrapper.TeamCard;
import com.example.spring_jpa_gradle.iowrapper.TeamInfoCard;
import com.example.spring_jpa_gradle.service.IPersonService;
import com.example.spring_jpa_gradle.service.IPlayerService;
import com.example.spring_jpa_gradle.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloBean {

    private final IPersonService personService;
    private final ITeamService teamService;
    private final IPlayerService playerService;

    @Autowired
    public HelloBean(IPersonService userService, ITeamService teamService, IPlayerService playerService) {
        this.personService = userService;
        this.teamService = teamService;
        this.playerService = playerService;
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
    @ResponseBody
    public ResponseEntity<String> teams() {
        List<ITeamCard> teamCards = teamService.getTeamsInfo();



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
    @GetMapping("/playersbyteam/{team_id}")
    public ResponseEntity<String> playersByTeam(@PathVariable Long team_id) {
        /*StringBuilder sb = new StringBuilder();
        sb.append("{\"players\": [");
        boolean first = true;
        for (String el : playerService.getPlayersInfo(team_id)) {
            if (first) first = false;
            else sb.append(",");
            sb.append(el);
        }
        sb.append("]}");*/
        PlayersByTeamCard pbtc = new PlayersByTeamCard(playerService.getPlayersInfo(team_id));
        return new ResponseEntity<String> (pbtc.toString(), HttpStatus.OK);
    }

    /*@GetMapping("/team")
    public String getTeam(@RequestParam Long number) {

    }*/


    @CrossOrigin
    @GetMapping("/teaminfo")
    @ResponseBody
    public ResponseEntity<String> teamInfo() {
        /*TeamCard teamCard = new TeamCard (
                teamService.getById(team_id),
                teamService.getGamesCount(team_id),
                teamService.getPointsAtHome(team_id),
                teamService.getPointsAsGuest(team_id)
        );*/

        TeamInfoCard tic = new TeamInfoCard(teamService.getTeamsInfo());
        return new ResponseEntity<String> (tic.toString(), HttpStatus.OK);
    }
}
