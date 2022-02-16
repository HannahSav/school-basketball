package com.example.spring_jpa_gradle.iservice;

import com.example.spring_jpa_gradle.iowrapper.IGameCard;

import java.util.List;

public interface IGameService {
    public List<IGameCard> getUpcomingGames();
    public List<IGameCard> getPastGames();
}
