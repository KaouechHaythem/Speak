package speak.example.SpeakBack.Documents;


import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Image extends Post {
    @Field(type = FieldType.Text)
    String content;

    public Image(String id, String description, String content) {
        super(id, description);
        this.content = content;
    }
}