package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.data.Team;

import java.util.List;

public interface ITeamService {
    //List<Team> findAll();
    public List<Team> getAll();
}
