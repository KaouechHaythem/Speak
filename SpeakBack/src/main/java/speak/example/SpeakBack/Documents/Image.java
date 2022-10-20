package speak.example.SpeakBack.Documents;



import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Image {
    private String id;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }




}