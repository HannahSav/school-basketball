package com.example.spring_jpa_gradle.iowrapper;

public interface ITeamCard {
    Integer getPhoto_id();
    String getName();
    Integer getGames_count();
    Integer getVictories();
    Integer getDraws();
    Integer getScored_home();
    Integer getScored_guest();
    Integer getTournament_score();
}
