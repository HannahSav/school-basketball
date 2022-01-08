package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.Person;

import java.util.List;

public interface IPersonService {
    Person findByPersonId(long personId);
    List<Person> findByLastName(String lastName);
    List<String> getBestPlayers();
}
