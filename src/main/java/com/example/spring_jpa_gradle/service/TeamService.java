package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.data.Team;
import com.example.spring_jpa_gradle.repository.PersonRepository;
import com.example.spring_jpa_gradle.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService {

    private final TeamRepository teamRepository;
    //private final PasswordEncoder passwordEncoder;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @Override
    public List<Team> getAll() {
       // StringBuilder sb = new StringBuilder();
        //teamRepository.findAll().stream().forEach(sb::append);
        //return sb.toString();
        return teamRepository.findAll();
    }

    //@Override
    //public List<String> findAll() {
    //    return teamRepository.findAll();
    //}

}
