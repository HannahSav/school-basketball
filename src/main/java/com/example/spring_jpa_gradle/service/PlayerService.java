package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.iowrapper.IPlayerStatisticCard;
import com.example.spring_jpa_gradle.iservice.IPlayerService;
import com.example.spring_jpa_gradle.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<IPlayerStatisticCard> getBestThreePointPlayers() { return playerRepository.getBestThreePointScorers(); }

    @Override
    public List<IPlayerStatisticCard> getBestTwoPointPlayers() { return playerRepository.getBestTwoPointScorers(); }

    @Override
    public List<IPlayerStatisticCard> getBestOnePointPlayers() { return playerRepository.getBestOnePointScorers(); }

    @Override
    public List<IPlayerStatisticCard> getBestRebounders() { return playerRepository.getBestRebounders(); }
}
