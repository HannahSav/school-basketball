package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.IPlayerCard;
import com.example.spring_jpa_gradle.data.PlayerCard;

import java.util.List;

public interface IPlayerService {
    public List<IPlayerCard> getPlayersInfo(Long team_id);
}
