package com.example.spring_jpa_gradle.repository;

import com.example.spring_jpa_gradle.data.IPlayerCard;
import com.example.spring_jpa_gradle.data.Player;
import com.example.spring_jpa_gradle.data.PlayerCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    /*@Query(value = "SELECT player.height, player.amplua, player.weight, player.number, person.last_name,\n" +
            "sum(two_points*2 + three_points*3 + free_throws) as points FROM player\n" +
            "JOIN statistics ON player.person_id = statistics.player_id\n" +
            "JOIN person ON player.person_id = person.person_id\n" +
            "JOIN team ON team.team_id = player.team_id\n" +
            "WHERE player.team_id = :team_id " +
            "GROUP BY player.height, player.amplua, player.weight, player.number, person.last_name\n" +
            "ORDER BY points DESC\n", nativeQuery = true)
    List<String> getNBestPlayers(@Param("team_id") Integer team_id, @Param("head") Long head);*/


    @Query(value = "SELECT player.height, player.amplua, player.weight, player.number, person.last_name, " +
            "sum(two_points*2 + three_points*3 + free_throws) as points FROM player " +
            "JOIN statistics ON player.person_id = statistics.player_id\n" +
            "JOIN person ON player.person_id = person.person_id\n" +
            "JOIN team ON team.team_id = player.team_id\n" +
            "WHERE player.team_id = :team_id " +
            "GROUP BY player.height, player.amplua, player.weight, player.number, person.last_name " +
            "ORDER BY points DESC LIMIT 5",
            nativeQuery = true)
    List<IPlayerCard> getNBestPlayers(@Param("team_id") Long team_id);
}

