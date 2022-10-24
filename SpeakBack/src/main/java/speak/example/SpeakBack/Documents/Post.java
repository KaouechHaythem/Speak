package speak.example.SpeakBack.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import speak.example.SpeakBack.helper.Indices;

@Document(indexName = Indices.POST_INDEX)
@Setting(settingPath = "static/es-settings.json")

public abstract class Post {
    @Field(type = FieldType.Keyword, name = "id")
    @Id
    private String id;
    //name
    //table postgresql
    //postgres
    //program
    //listener
    //synchronisation
    @Field(type = FieldType.Text, name = "description")
    private String description;

    public Post(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
