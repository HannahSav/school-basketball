package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.iowrapper.IGameCard;
import com.example.spring_jpa_gradle.iservice.IGameService;
import com.example.spring_jpa_gradle.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService implements IGameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<IGameCard> getUpcomingGames() {
        return gameRepository.getUpcomingGames();
    }

    @Override
    public List<IGameCard> getPastGames() {
        return gameRepository.getPastGames();
    }
}
