package speak.example.SpeakBack.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import speak.example.SpeakBack.Documents.Post;
import speak.example.SpeakBack.repository.PostRepository;

import java.util.List;

@Service
public class PostService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final PostRepository postRepository;
    private final RestHighLevelClient client;

    @Autowired
    public PostService(PostRepository postRepository, RestHighLevelClient client) {
        this.postRepository = postRepository;

        this.client = client;
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public Post findById(String id) {
        return postRepository.findById(id).orElse(null);
    }

    public List<Post> searchByDescription(final String description) {
        return postRepository.findByDescriptionLike(description);
    }

    public List<Post> findByIdContaining(final String id) {
        return postRepository.findByIdContaining(id);
    }

    public void delete(String id) {
        postRepository.deleteById(id);
    }
    public  List<Post> findAll(){
        return (List<Post>) postRepository.findAll();
    }


}
