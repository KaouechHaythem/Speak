package com.speak.speakpostgresql.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("IMG")
@Table(name = "IMAGE")
public class Image extends Publication {
    public Image(String name, String description, String type, String content, String ownedId) {
        super(name, description, type, content, ownedId);
    }

    public Image() {
    }
}
