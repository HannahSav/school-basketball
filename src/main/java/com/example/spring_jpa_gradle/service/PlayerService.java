package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.IPlayerCard;
import com.example.spring_jpa_gradle.data.PlayerCard;
import com.example.spring_jpa_gradle.repository.PlayerRepository;
import com.example.spring_jpa_gradle.repository.TeamRepository;
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
    public List<IPlayerCard> getPlayersInfo(Long team_id) {
        return playerRepository.getNBestPlayers(team_id);
    }
}
