package com.example.spring_jpa_gradle.iowrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class GameCard implements Serializable, IGameCard {
    private Integer points_home_team;
    private Integer points_guest_team;
    private String name_home_team;
    private String name_guest_team;
    private Date time;
    private String gym;

    GameCard(Integer points_home_team,
            Integer points_guest_team,
            String name_home_team,
            String name_guest_team,
            Date time,
            String gym) {

        this.points_home_team = points_home_team;
        this.points_guest_team = points_guest_team;
        this.name_home_team = name_home_team;
        this.name_guest_team = name_guest_team;
        this.time = time;
        this.gym = gym;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("GameCard serialization ERROR\n");
            out.append(e.getMessage());
        }
        return out.toString();
    }

    public Integer getPoints_home_team() {
        return points_home_team;
    }

    public Integer getPoints_guest_team() {
        return points_guest_team;
    }

    public String getName_home_team() {
        return name_home_team;
    }

    public String getName_guest_team() {
        return name_guest_team;
    }

    public Date getTime() {
        return time;
    }

    public String getGym() {
        return gym;
    }
}
