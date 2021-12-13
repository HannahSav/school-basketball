package com.example.spring_jpa_gradle.data;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "player_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person personId;

    @Column(name = "height")
    private Double height;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "number")
    private Integer number;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "amplua")
    private Amplua amplua;

    @ManyToOne()
    @JoinColumn(name="team_id", referencedColumnName = "team_id", insertable = false, updatable = false)
    private Team teamId;

}
