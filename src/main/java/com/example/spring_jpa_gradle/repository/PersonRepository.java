package com.example.spring_jpa_gradle.repository;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.data.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByPersonId(long personId);
    List<Person> findByLastName(String lastName);

    @Query(value = "SELECT person.first_name, person.last_name,\n" +
            "sum(two_points*2 + three_points*3 + free_throws) as points FROM player\n" +
            "JOIN statistics ON player.person_id = statistics.player_id\n" +
            "JOIN person ON player.person_id = person.person_id\n" +
             "GROUP BY person.first_name, person.last_name\n" +
            "ORDER BY points DESC;\n", nativeQuery = true)
    List<String> getBestPlayers();

}
