package com.speak.speakpostgresql.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@DiscriminatorValue("PUB")
@Table(name = "PUBLICATION")

public class Publication extends GlobalObject {
    private String content;
    private String ownedId;

    public Publication(String name, String description, String type, String content, String ownedId) {
        super(name, description, type);
        this.content = content;
        this.ownedId = ownedId;
    }

    public Publication() {
        super();
        this.content = "";
        this.ownedId = "";
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOwnerId() {
        return ownedId;
    }

    public void setOwnerId(String owner) {
        this.ownedId = owner;
    }
}
