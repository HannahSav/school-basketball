package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.Person;
import com.example.spring_jpa_gradle.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    private final PersonRepository userRepository;
    //private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Person findByPersonId(long personId) {
        return userRepository.findById(personId).get();
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return userRepository.findByLastName(lastName);
    }

    @Override
    public List<String> getBestPlayers() { return userRepository.getBestPlayers(); }

}
