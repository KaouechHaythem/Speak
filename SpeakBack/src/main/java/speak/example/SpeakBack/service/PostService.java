package speak.example.SpeakBack.service;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import speak.example.SpeakBack.Documents.Post;
import speak.example.SpeakBack.helper.Indices;
import speak.example.SpeakBack.repository.PostRepository;
import speak.example.SpeakBack.search.SearchRequestDTO;
import speak.example.SpeakBack.search.util.SearchUtil;
import org.elasticsearch.action.search.SearchRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PostService {
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final PostRepository postRepository;
    private  final RestHighLevelClient client;
    @Autowired
    public PostService(PostRepository postRepository, RestHighLevelClient client){
        this.postRepository = postRepository;

        this.client = client;
    }
    public void save(Post post){
        postRepository.save(post);
    }
    public Post findById(String id){
        return postRepository.findById(id).orElse(null);
    }
    public List<Post> searchByContent (final String content ){return postRepository.findByContentContaining(content);}
    public List<Post> findByIdContaining (final String id ){return postRepository.findByIdContaining(id);}
    public List<Post> search (final SearchRequestDTO dto ){
        final  SearchRequest request = SearchUtil.buildSearchRequest(Indices.POST_INDEX,dto);
        if ((request==null)){
            return Collections.EMPTY_LIST;
        }
        try {
            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);
            final SearchHit[] searchHits =response.getHits().getHits();
            final List<Post> posts= new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                posts.add(
                        MAPPER.readValue(hit.getSourceAsString(),Post.class)
                );
            }

            return posts;
        } catch (IOException e) {


            return Collections.EMPTY_LIST;
        }
    }
}
