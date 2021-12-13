package com.example.spring_jpa_gradle.data;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "statistics_id")
    private Long statistics_id;

    @ManyToOne
    @JoinColumn(name="player_id", nullable=false)
    private Player player;

    @ManyToOne
    @JoinColumn(name="game_id", nullable=false)
    private Game game;

    @Column(name = "two_points")
    private Integer two_points;

    @Column(name = "two_points_made")
    private Integer two_points_made;

    @Column(name = "three_points")
    private Integer three_points;

    @Column(name = "three_points_made")
    private Integer three_points_made;

    @Column(name = "free_throws")
    private Integer free_throws;

    @Column(name = "free_throws_made")
    private Integer free_throws_made;

    @Column(name = "offensive_rebounds")
    private Integer offensiveRebounds;

    @Column(name = "defensive_rebounds")
    private Integer defensiveRebounds;
}
