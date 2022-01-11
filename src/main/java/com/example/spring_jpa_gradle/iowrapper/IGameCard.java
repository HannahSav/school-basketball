package com.example.spring_jpa_gradle.iowrapper;

import java.util.Date;

public interface IGameCard {
    Integer getPoints_home_team();
    Integer getPoints_guest_team();
    String getName_home_team();
    String getName_guest_team();
    Date getTime();
    String getGym();
}
