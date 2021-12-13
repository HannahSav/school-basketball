package com.example.spring_jpa_gradle.data;

import javax.persistence.*;

@Entity
@Table(name = "gym")
public class Gym {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long gymId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "photo_id")
    private Integer photoId;
}
