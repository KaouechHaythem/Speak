package speak.example.SpeakBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import speak.example.SpeakBack.Documents.Image;
import speak.example.SpeakBack.Documents.Post;
import speak.example.SpeakBack.Documents.Text;
import speak.example.SpeakBack.Documents.Video;
import speak.example.SpeakBack.service.PostService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    @PostMapping(path = "/savetxt")
    public void saveTxt(@RequestBody Text txt){
        postService.save(txt);
    }
    @PostMapping(path = "/saveimg")
    public void saveImg(@RequestBody  Image img){
        postService.save(img);
    }
    @PostMapping(path = "/savevd")
    public void saveVd(@RequestBody Video vd){
        postService.save(vd);
    }
    @PostMapping(path = "/searchdes")
    public List<Post>  searchByDescription(@RequestParam( "text") String text) throws UnsupportedEncodingException {

        return  postService.searchByDescription(URLEncoder.encode(text, "UTF-8"));
    }
    @GetMapping(path = "/searchid")
    public List<Post> searchByIdContaining(@RequestParam("id") String id){
       return   postService.findByIdContaining(id);
    }
    @DeleteMapping(path = "delete/{id}")
    public void delete (@PathVariable(name = "id")String id){
        postService.delete(id);
    }
    @GetMapping(path = "/findall")
    public List<Post> findall(){
        return   postService.findAll();
    }
}
