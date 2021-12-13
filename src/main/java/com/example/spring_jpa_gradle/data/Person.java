package com.example.spring_jpa_gradle.data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "photo_id")
    private Long photoId;

    public Person() {}

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Person[")
                .append("person_id=").append(personId)
                .append(", ").append("first_name=").append(firstName)
                .append(", ").append("last_name=").append(lastName);
        if (null != patronymic) out.append(", ").append("patronymic=").append(patronymic);
        if (null != birthDate) out.append(", ").append("birth_date=").append(birthDate);
        if (null != photoId) out.append(", ").append("photo_id=").append(photoId);
        return out.toString();
    }

    public Long getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }
}
