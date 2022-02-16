package com.example.spring_jpa_gradle.iowrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class GameInfoCard implements Serializable {
    private List<IGameCard> gameInfo;

    public GameInfoCard(List<IGameCard> gameInfo) {
        this.gameInfo = gameInfo;
    }

    public List<IGameCard> getTeamInfo() {
        return gameInfo;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("GameInfoCard serialization ERROR\n");
            out.append(e.getMessage());
        }
        return out.toString();
    }
}
