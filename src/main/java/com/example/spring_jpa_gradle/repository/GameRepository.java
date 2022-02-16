package com.example.spring_jpa_gradle.repository;

import com.example.spring_jpa_gradle.data.Game;
import com.example.spring_jpa_gradle.iowrapper.IGameCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(value = "SELECT game.points_home_team, game.points_guest_team,\n" +
            "       home.name as name_home_team, guest.name as name_guest_team,\n" +
            "       game.time, place.name as gym FROM game\n" +
            "JOIN team home on game.home_team_id = home.team_id\n" +
            "JOIN team guest on game.guest_team_id = guest.team_id\n" +
            "JOIN gym place on place.gym_id = game.gym_id\n" +
            "WHERE game.time < now()\n" +
            "ORDER BY game.time DESC;", nativeQuery = true)
    List<IGameCard> getPastGames();

    @Query(value = "SELECT game.points_home_team, game.points_guest_team,\n" +
            "       home.name as name_home_team, guest.name as name_guest_team,\n" +
            "       game.time, place.name as gym FROM game\n" +
            "JOIN team home on game.home_team_id = home.team_id\n" +
            "JOIN team guest on game.guest_team_id = guest.team_id\n" +
            "JOIN gym place on place.gym_id = game.gym_id\n" +
            "WHERE game.time > now()\n" +
            "ORDER BY game.time;", nativeQuery = true)
    List<IGameCard> getUpcomingGames();
}
