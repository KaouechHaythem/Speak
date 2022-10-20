package speak.example.SpeakBack.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import speak.example.SpeakBack.Documents.Post;

import java.util.List;

public interface PostRepository extends ElasticsearchRepository<Post,String> {
    List<Post> findByContentContaining(String content);
    List<Post> findByIdContaining(String id);

}
