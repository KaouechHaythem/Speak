package speak.example.SpeakBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import speak.example.SpeakBack.Documents.Post;
import speak.example.SpeakBack.service.PostService;

import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/{id}")
    public Post findByID(@PathVariable(value = "id") String id){
        return postService.findById(id);
    }
    @PostMapping(path = "/save")
    public void savePost(@RequestBody Post post){
        postService.save(post);
    }
    @PostMapping(path = "/searchcontent")
    public List<Post>  searchByContent(@RequestParam( "text") String text){
        return  postService.searchByContent(text);
    }
    @GetMapping(path = "/searchid")
    public List<Post> searchByIdContaining(@RequestParam("id") String id){
       return   postService.findByIdContaining(id);
    }
}
