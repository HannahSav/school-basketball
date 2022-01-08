package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.data.Team;
import com.example.spring_jpa_gradle.iowrapper.ITeamCard;
import com.example.spring_jpa_gradle.iowrapper.TeamCard;

import java.util.List;

public interface ITeamService {
    //List<Team> findAll();
    public List<Team> getAll();
    public List<ITeamCard> getTeamsInfo();
    public Integer getGamesCount(Long id);
    public Integer getPointsAtHome(Long id);
    public Integer getPointsAsGuest(Long id);
    public Team getById(Long id);
    public Long count();
}
