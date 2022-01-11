package com.example.spring_jpa_gradle.iowrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class PlayerStatisticCard implements Serializable, IPlayerStatisticCard {
    private String first_name;
    private String last_name;
    private String team_name;
    private Integer points;

    public PlayerStatisticCard(String first_name,
                               String last_name,
                               String team_name,
                               Integer points) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.team_name = team_name;
        this.points = points;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("PlayerStatisticCard serialization ERROR\n");
            out.append(e.getMessage());
        }
        return out.toString();
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getTeam_name() {
        return team_name;
    }

    public Integer getPoints() {
        return points;
    }
}
