package com.speak.speakpostgresql.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("PT")
@Table(name = "POST")
public class Post extends Publication {
    public Post() {
    }

    public Post(String name, String description, String type, String content, String ownedId) {
        super(name, description, type, content, ownedId);
    }
}
