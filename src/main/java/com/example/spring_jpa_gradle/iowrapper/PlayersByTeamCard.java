package com.example.spring_jpa_gradle.iowrapper;

import com.example.spring_jpa_gradle.data.Amplua;
import com.example.spring_jpa_gradle.data.IPlayerCard;
import com.example.spring_jpa_gradle.data.PlayerCard;
import com.example.spring_jpa_gradle.data.Team;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class PlayersByTeamCard implements Serializable {
    private List<IPlayerCard> playerInfo;

    public PlayersByTeamCard(List<IPlayerCard> playerInfo) {
        this.playerInfo = playerInfo;
    }

    public List<IPlayerCard> getPlayerInfo() {
        return playerInfo;
    }
    
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("PlayersByTeamCard serialization ERROR\n");
            out.append(e.getMessage());
        }
        return out.toString();
    }
}
