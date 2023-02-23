package com.speak.speakelastic.controller;

import com.speak.speakelastic.documents.GlobalObject;
import com.speak.speakelastic.service.GObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("api/v1/post")
public class PostController {

    private final GObjectService GObjectService;

    @Autowired
    public PostController(GObjectService GObjectService) {
        this.GObjectService = GObjectService;
    }

    @PostMapping(path = "/saveObject")
    public void saveTxt(GlobalObject object) {
        GObjectService.save(object);
    }

    /**
     * search a term in the description of an object
     *
     * @param text
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping(path = "/search/{text}/{type}")
    public List<GlobalObject> searchByDescription(@PathVariable("text") String text,@PathVariable("type") String type) throws UnsupportedEncodingException {

        return GObjectService.searchByDescription(URLEncoder.encode(text, "UTF-8"),URLEncoder.encode(text, "UTF-8"),URLEncoder.encode(type, "UTF-8"));
    }

    /**
     * delete an object by id
     *
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable(name = "id") String id) {
        GObjectService.delete(id);
    }

    /**
     * find one object by id
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public GlobalObject getOne(@PathVariable(name = "id") String id) {
        return GObjectService.getOne(id);
    }


}