package com.example.spring_jpa_gradle.data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "team_award")
public class TeamAward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne()
    @JoinColumn(name="team_id", referencedColumnName = "team_id", insertable = false, updatable = false)
    private Team team;
}
