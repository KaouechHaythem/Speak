package com.speak.speakpostgresql.model;

import com.speak.speakpostgresql.service.ListenerService;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@DiscriminatorColumn(name = "OBJECTTYPE")
@Table(name = "GLOBALOBJECT")
@EntityListeners(ListenerService.class)
public class GlobalObject {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id;
    private String name;
    private String description;
    private String type ;

    public GlobalObject(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public GlobalObject() {
        this.description="";
        this.name="";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "GlobalObject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
