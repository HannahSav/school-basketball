package com.example.spring_jpa_gradle.iservice;

import com.example.spring_jpa_gradle.iowrapper.ITeamCard;

import java.util.List;

public interface ITeamService {
    List<ITeamCard> getTeamsInfo();
}
