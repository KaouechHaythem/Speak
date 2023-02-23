package com.speak.speakpostgresql.controller;

import com.speak.speakpostgresql.model.Publication;
import com.speak.speakpostgresql.service.KafkaProdeucerService;
import com.speak.speakpostgresql.service.PublicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/pub")
public class PublicationController {
    @Autowired
    private PublicationService publicationService;
    @Autowired
    private KafkaProdeucerService kafkaProdeucerService;

    /**
     * save a publication
     *
     * @param pub
     */
    @PostMapping(path = "/save")
    public void addPub(@RequestBody Publication pub) {
        this.publicationService.addPub(pub);
    }

    /**
     * delete a publication by id
     *
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deletePub(@PathVariable(name = "id") String id) {
        this.publicationService.deletePub(id);
    }

    /**
     * download and save a publication
     *
     * @param file
     * @param description
     * @param owner
     * @param type
     * @throws IOException
     */
    @PostMapping(path = "/download")
    public void download(@RequestParam("file") MultipartFile file,
                         @RequestParam("description") String description,
                         @RequestParam("owner") String owner,
                         @RequestParam("type") String type) throws IOException {
        this.publicationService.download(file, description, owner, type);
    }
    @PostMapping(path = "/post")
    public void post(
                         @RequestParam("description") String description,
                         @RequestParam("owner") String owner,
                         @RequestParam("type") String type) throws IOException {
        this.publicationService.post( description, owner, type);
    }


}
