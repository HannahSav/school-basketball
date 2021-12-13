package com.example.spring_jpa_gradle.data;

import javax.persistence.*;
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

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Team: {\n")
                .append("team_id: ").append(teamId)
                .append(",\n").append("name: ").append(name)
                .append(",\n").append("school: ").append(school);
        if (null != class_group) out.append(",\n").append("class_group: ").append(class_group);
        out.append("\n}");
        return out.toString();
    }
}
