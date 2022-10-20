package speak.example.SpeakBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import speak.example.SpeakBack.Documents.Post;
import speak.example.SpeakBack.search.SearchRequestDTO;
import speak.example.SpeakBack.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    private final PostService postService;
@Autowired
    public SearchController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/posts")
    public List<Post> searchPosts(@RequestBody final SearchRequestDTO dto){
    return postService.search(dto);
    }
}
