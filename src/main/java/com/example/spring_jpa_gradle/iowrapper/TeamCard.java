package com.example.spring_jpa_gradle.iowrapper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class TeamCard implements Serializable, ITeamCard {

    private Integer photo_id;
    private String name;
    private Integer games_count;
    private Integer victories;
    private Integer draws;
    private Integer scored_home;
    private Integer scored_guest;
    private Integer tournament_score;

    public TeamCard(Integer photo_id,
                    String name,
                    Integer games_count,
                    Integer victories,
                    Integer draws,
                    Integer scored_home,
                    Integer scored_guest,
                    Integer tournament_score) {

        this.photo_id = photo_id;
        this.name = name;
        this.games_count = games_count;
        this.victories = victories;
        this.draws = draws;
        this.scored_home = scored_home;
        this.scored_guest = scored_guest;
        this.tournament_score = tournament_score;
    }



    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("TeamCard serialization ERROR\n");
            out.append(e.getMessage());
        }
        return out.toString();
    }

    public Integer getPhoto_id() {
        return photo_id;
    }

    public String getName() {
        return name;
    }

    public Integer getGames_count() {
        return games_count;
    }

    public Integer getVictories() {
        return victories;
    }

    public Integer getDraws() {
        return draws;
    }

    public Integer getScored_home() {
        return scored_home;
    }

    public Integer getScored_guest() {
        return scored_guest;
    }

    public Integer getTournament_score() {
        return tournament_score;
    }
}
