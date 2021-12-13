package com.example.spring_jpa_gradle.repository;

import com.example.spring_jpa_gradle.data.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    //@Query(value = "SELECT * FROM team", nativeQuery = true)
    //List<Team> findAll();
}
