package com.example.spring_jpa_gradle.iservice;

import com.example.spring_jpa_gradle.iowrapper.IPlayerStatisticCard;

import java.util.List;

public interface IPlayerService {
    List<IPlayerStatisticCard> getBestThreePointPlayers();
    List<IPlayerStatisticCard> getBestTwoPointPlayers();
    List<IPlayerStatisticCard> getBestOnePointPlayers();
    List<IPlayerStatisticCard> getBestRebounders();
}
