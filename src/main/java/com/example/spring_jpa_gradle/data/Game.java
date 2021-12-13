package com.example.spring_jpa_gradle.data;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long game_id;

    @ManyToOne
    @JoinColumn(name="home_team_id", nullable=false)
    private Team home_team;

    @ManyToOne
    @JoinColumn(name="guest_team_id", nullable=false)
    private Team guest_team;

    @ManyToOne
    @JoinColumn(name="gym_id", nullable=false)
    private Gym gym;

}
