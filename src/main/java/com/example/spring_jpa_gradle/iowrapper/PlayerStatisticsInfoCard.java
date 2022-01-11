package com.example.spring_jpa_gradle.iowrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class PlayerStatisticsInfoCard implements Serializable {
    private List<IPlayerStatisticCard> playerStatInfo;

    public PlayerStatisticsInfoCard(List<IPlayerStatisticCard> playerStatInfo) {
        this.playerStatInfo = playerStatInfo;
    }

    public List<IPlayerStatisticCard> getTeamInfo() {
        return playerStatInfo;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("PlayerStatisticsInfoCard serialization ERROR\n");
            out.append(e.getMessage());
        }
        return out.toString();
    }
}
