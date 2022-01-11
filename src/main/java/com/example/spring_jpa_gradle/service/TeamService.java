package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.Team;
import com.example.spring_jpa_gradle.iowrapper.ITeamCard;
import com.example.spring_jpa_gradle.iservice.ITeamService;
import com.example.spring_jpa_gradle.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<ITeamCard> getTeamsInfo() {
        return teamRepository.getTeamsInfo();
    }

}
