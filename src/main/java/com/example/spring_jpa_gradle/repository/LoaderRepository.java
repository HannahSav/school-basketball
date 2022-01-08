package com.example.spring_jpa_gradle.repository;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.data.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaderRepository extends JpaRepository<Team, Long> {
    //@Query(value = "INSERT INTO team (name, school, class) " +
    //        "VALUES (:name, :name, :class);",
    //        nativeQuery = true)
    //void loadTeam(@Param("name") String name, @Param("school") String school, @Param("class") String class_group);
}
