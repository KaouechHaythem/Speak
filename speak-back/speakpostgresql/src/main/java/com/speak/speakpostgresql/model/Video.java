package com.speak.speakpostgresql.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("VD")
@Table(name = "VIDEO")
public class Video extends Publication {
    public Video(String name, String description, String type, String content, String ownedId) {
        super(name, description, type, content, ownedId);
    }

    public Video() {
    }
}
