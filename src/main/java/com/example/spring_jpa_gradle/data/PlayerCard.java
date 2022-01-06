package com.example.spring_jpa_gradle.data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PlayerCard {
    @Column(name = "height")
    public Double height;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "amplua")
    public Amplua amplua;
    @Column(name = "weight")
    public Double weight;
    @Column(name = "last_name")
    public String last_name;
    @Column(name = "points")
    public Integer points;
}
