package speak.example.SpeakBack.repository;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import speak.example.SpeakBack.Documents.Post;

import java.util.List;

public interface PostRepository extends ElasticsearchRepository<Post, String> {

    @Query(value = "")
    List<Post> findByDescriptionLike(String content);

    List<Post> findByIdContaining(String id);

}
