package com.example.spring_jpa_gradle.iowrapper;

import com.example.spring_jpa_gradle.data.IPlayerCard;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class TeamInfoCard implements Serializable {
    private List<ITeamCard> teamInfo;

    public TeamInfoCard(List<ITeamCard> teamInfo) {
        this.teamInfo = teamInfo;
    }

    public List<ITeamCard> getTeamInfo() {
        return teamInfo;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("TeamInfoCard serialization ERROR\n");
            out.append(e.getMessage());
        }
        return out.toString();
    }
}
