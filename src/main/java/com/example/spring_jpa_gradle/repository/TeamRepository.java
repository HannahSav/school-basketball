package com.example.spring_jpa_gradle.repository;

import com.example.spring_jpa_gradle.data.IPlayerCard;
import com.example.spring_jpa_gradle.data.Team;
import com.example.spring_jpa_gradle.iowrapper.ITeamCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    @Query(value = "SELECT COUNT(*) FROM game " +
            "WHERE game.home_team_id = :team_id OR game.guest_team_id = :team_id",
            nativeQuery = true)
    Integer countGames(@Param("team_id") Long team_id);

    @Query(value = "SELECT sum(two_points*2 + three_points*3 + free_throws) FROM team " +
            "JOIN game g on (team.team_id = g.home_team_id) " +
            "JOIN player p on team.team_id = p.team_id " +
            "JOIN statistics s on (p.player_id = s.player_id AND g.home_team_id = s.game_id) " +
            "WHERE p.team_id = :team_id",
            nativeQuery = true)
    Integer pointsAtHome(@Param("team_id") Long team_id);

    @Query(value = "SELECT sum(two_points*2 + three_points*3 + free_throws) FROM team " +
            "JOIN game g on (team.team_id = g.guest_team_id) " +
            "JOIN player p on team.team_id = p.team_id " +
            "JOIN statistics s on (p.player_id = s.player_id AND g.home_team_id = s.game_id) " +
            "WHERE p.team_id = :team_id",
            nativeQuery = true)
    Integer pointsAsGuest(@Param("team_id") Long team_id);

    @Query(value = "SELECT *, sum(victories*2 + draws) as tournament_score FROM (\n" +
            "                  SELECT team.photo_id, team.name, COUNT(game_id) as games_count,\n" +
            "                         COUNT(winner_id) filter (where winner_id = team.team_id) as victories,\n" +
            "                         COUNT(winner_id) filter (where winner_id = 0) as draws,\n" +
            "                         SUM(points_home_team) filter (where team.team_id = g.home_team_id) as scored_home,\n" +
            "                         SUM(points_guest_team) filter (where team.team_id = g.guest_team_id) as scored_guest\n" +
            "                  FROM team\n" +
            "                           JOIN game g on team.team_id = g.guest_team_id or team.team_id = g.home_team_id\n" +
            "                  GROUP BY team.photo_id, team.name\n" +
            ") as res\n" +
            "GROUP BY res.photo_id, res.name, res.games_count, res.victories, res.draws, res.scored_home, res.scored_guest\n" +
            "ORDER BY sum(victories*2 + draws) DESC;", nativeQuery = true)
    List<ITeamCard> getTeamsInfo();
}
