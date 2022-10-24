package speak.example.SpeakBack.Documents;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

public class Video extends Post {
    @Field(type = FieldType.Text)
    String content;

    public Video(String id, String description, String content) {
        super(id, description);
        this.content = content;
    }
}
