package com.example.spring_jpa_gradle.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.IOException;
import java.io.Serializable;

@Entity
@Table(name = "team")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "team_id")
    private Long teamId;

    @Column(name = "name")
    private String name;

    @Column(name = "school")
    private String school;

    @Column(name = "class")
    private String class_group;

    @Column(name = "photo_id")
    private Integer photo_id;

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getClass_group() {
        return class_group;
    }

    public void setClass_group(String class_group) {
        this.class_group = class_group;
    }

    public void setPhoto_id(Integer photo_id) { this.photo_id = photo_id; }

    public Integer getPhoto_id() { return photo_id; }

    @Override
    public String toString() {

        StringBuilder out = new StringBuilder();
        /*out.append("{{Team: {\n")
                .append("team_id: ").append(teamId)
                .append(",\n").append("name: ").append(name)
                .append(",\n").append("school: ").append(school);
        if (null != class_group) out.append(",\n").append("class_group: ").append(class_group);
        out.append("\n}\n}");*/

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            out.append(objectMapper.writeValueAsString(this));
        } catch (IOException e) {
            out.append("ERROR");
        }
        return out.toString();
    }
}
