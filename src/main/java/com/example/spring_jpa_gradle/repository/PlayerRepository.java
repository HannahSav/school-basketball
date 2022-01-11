package com.example.spring_jpa_gradle.repository;

import com.example.spring_jpa_gradle.data.Player;
import com.example.spring_jpa_gradle.iowrapper.IPlayerStatisticCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT pers.first_name, pers.last_name, t.name as team_name, SUM(s.three_points) as points FROM player p\n" +
            "JOIN statistics s on p.player_id = s.player_id\n" +
            "JOIN team t on p.team_id = t.team_id\n" +
            "JOIN person pers on p.person_id = pers.person_id\n" +
            "GROUP BY pers.first_name, pers.last_name, t.name\n" +
            "ORDER BY SUM(s.three_points) DESC LIMIT 5;\n" +
            "\n", nativeQuery = true)
    List<IPlayerStatisticCard> getBestThreePointScorers();

    @Query(value = "SELECT pers.first_name, pers.last_name, t.name as team_name, SUM(s.two_points) as points FROM player p\n" +
            "JOIN statistics s on p.player_id = s.player_id\n" +
            "JOIN team t on p.team_id = t.team_id\n" +
            "JOIN person pers on p.person_id = pers.person_id\n" +
            "GROUP BY pers.first_name, pers.last_name, t.name\n" +
            "ORDER BY SUM(s.two_points) DESC LIMIT 5;", nativeQuery = true)
    List<IPlayerStatisticCard> getBestTwoPointScorers();

    @Query(value = "SELECT pers.first_name, pers.last_name, t.name as team_name, SUM(s.free_throws) as points FROM player p\n" +
            "JOIN statistics s on p.player_id = s.player_id\n" +
            "JOIN team t on p.team_id = t.team_id\n" +
            "JOIN person pers on p.person_id = pers.person_id\n" +
            "GROUP BY pers.first_name, pers.last_name, t.name\n" +
            "ORDER BY SUM(s.free_throws) DESC LIMIT 5;", nativeQuery = true)
    List<IPlayerStatisticCard> getBestOnePointScorers();

    @Query(value = "SELECT pers.first_name, pers.last_name, t.name as team_name, SUM(s.offensive_rebounds + s.defensive_rebounds) as points FROM player p\n" +
            "JOIN statistics s on p.player_id = s.player_id\n" +
            "JOIN team t on p.team_id = t.team_id\n" +
            "JOIN person pers on p.person_id = pers.person_id\n" +
            "GROUP BY pers.first_name, pers.last_name, t.name\n" +
            "ORDER BY SUM(s.offensive_rebounds + s.defensive_rebounds) DESC LIMIT 5;", nativeQuery = true)
    List<IPlayerStatisticCard> getBestRebounders();

}

