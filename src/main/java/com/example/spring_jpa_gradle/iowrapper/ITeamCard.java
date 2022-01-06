package com.example.spring_jpa_gradle.iowrapper;

public interface ITeamCard {
    public Integer getPhoto_id();

    public String getName();

    public Integer getGames_count();

    public Integer getVictories();

    public Integer getDraws();

    public Integer getScored_home();

    public Integer getScored_guest();

    public Integer getTournament_score();
}
