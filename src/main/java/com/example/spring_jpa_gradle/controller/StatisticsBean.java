package com.example.spring_jpa_gradle.controller;

import com.example.spring_jpa_gradle.iowrapper.*;
import com.example.spring_jpa_gradle.iservice.IGameService;
import com.example.spring_jpa_gradle.iservice.IPlayerService;
import com.example.spring_jpa_gradle.iservice.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class StatisticsBean {

    private final ITeamService teamService;
    private final IPlayerService playerService;
    private final IGameService gameService;

    @Autowired
    public StatisticsBean(ITeamService teamService, IPlayerService playerService, IGameService gameService) {
        this.teamService = teamService;
        this.playerService = playerService;
        this.gameService = gameService;
    }

    @GetMapping("/teaminfo")
    @ResponseBody
    public ResponseEntity<String> teamInfo() {
        TeamInfoCard tic = new TeamInfoCard(teamService.getTeamsInfo());
        return new ResponseEntity<String> (tic.toString(), HttpStatus.OK);
    }

    @GetMapping("/best3p")
    @ResponseBody
    public ResponseEntity<String> getBestThreePointScorers() {
        PlayerStatisticsInfoCard psic = new PlayerStatisticsInfoCard(playerService.getBestThreePointPlayers());
        return new ResponseEntity<String> (psic.toString(), HttpStatus.OK);
    }

    @GetMapping("/best2p")
    @ResponseBody
    public ResponseEntity<String> getBestTwoPointScorers() {
        PlayerStatisticsInfoCard psic = new PlayerStatisticsInfoCard(playerService.getBestTwoPointPlayers());
        return new ResponseEntity<String> (psic.toString(), HttpStatus.OK);
    }

    @GetMapping("/best1p")
    @ResponseBody
    public ResponseEntity<String> getBestOnePointScorers() {
        PlayerStatisticsInfoCard psic = new PlayerStatisticsInfoCard(playerService.getBestOnePointPlayers());
        return new ResponseEntity<String> (psic.toString(), HttpStatus.OK);
    }

    @GetMapping("/bestrebounders")
    @ResponseBody
    public ResponseEntity<String> getBestRebounders() {
        PlayerStatisticsInfoCard psic = new PlayerStatisticsInfoCard(playerService.getBestRebounders());
        return new ResponseEntity<String> (psic.toString(), HttpStatus.OK);
    }

    @GetMapping("/pastgames")
    @ResponseBody
    public ResponseEntity<String> getPastGames() {
        GameInfoCard gic = new GameInfoCard(gameService.getPastGames());
        return new ResponseEntity<String> (gic.toString(), HttpStatus.OK);
    }

    @GetMapping("/upcominggames")
    @ResponseBody
    public ResponseEntity<String> getUpcomingGames() {
        GameInfoCard gic = new GameInfoCard(gameService.getUpcomingGames());
        return new ResponseEntity<String> (gic.toString(), HttpStatus.OK);
    }
}
