package speak.example.SpeakBack.Documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import speak.example.SpeakBack.helper.Indices;

@Document(indexName = Indices.POST_INDEX)
@Setting(settingPath = "static/es-settings.json")
public  class Post {
    @Field(type = FieldType.Keyword,name = "id")
    @Id
    private String id ;
    @Field(type = FieldType.Text,name = "content")
    private String content ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
