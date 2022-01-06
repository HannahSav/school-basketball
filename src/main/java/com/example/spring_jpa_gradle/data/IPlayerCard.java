package com.example.spring_jpa_gradle.data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public interface IPlayerCard {

    public Double getHeight();

    public Amplua getAmplua();

    public Double getWeight();

    public String getLast_name();

    public Integer getPoints();
}
