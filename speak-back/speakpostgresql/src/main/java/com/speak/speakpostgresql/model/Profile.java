package com.speak.speakpostgresql.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("PRO")
@Table(name = "PROFILE")
public class Profile extends GlobalObject {
    String lastName;
    String email;
    int age;

    public Profile() {
        super();
        this.age = 0;
        this.email = "";
        this.lastName = "";
    }


    public Profile(String name, String description, String type, String lastName, String email, int age) {
        super(name, description, type);
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
