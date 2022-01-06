package com.example.spring_jpa_gradle.service;

import com.example.spring_jpa_gradle.data.Team;
import com.example.spring_jpa_gradle.loader.TeamGenerator;
import com.example.spring_jpa_gradle.repository.LoaderRepository;
import com.example.spring_jpa_gradle.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoaderService implements ILoaderService {

    private final LoaderRepository loaderRepository;
    //private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoaderService(LoaderRepository loaderRepository) {
        this.loaderRepository = loaderRepository;
    }

    @Override
    public void loadTeams(long number) {
        Team next;
        for (int i=0; i<number; i++) {
            next = TeamGenerator.generate_team();
            //loaderRepository.loadTeam(next.getName(), next.getSchool(), next.getClass_group());
            loaderRepository.save(next);
        }
    }
}
