package com.speak.speakpostgresql.controller;

import com.speak.speakpostgresql.model.GlobalObject;
import com.speak.speakpostgresql.service.GlobalObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

@RestController
@RequestMapping("api/v1/search")
public class SearchController {
    @Autowired
    private GlobalObjectService globalObjectService;

    /**
     * search a term by description
     *
     * @param searchTerm
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping("/{searchTerm}")
    public List<GlobalObject> search(@PathVariable() String searchTerm) throws UnsupportedEncodingException {
        return this.globalObjectService.search(URLEncoder.encode(searchTerm, "UTF-8"));

    }

    /**
     * return all objects
     *
     * @return
     * @throws UnsupportedEncodingException
     */
    @GetMapping()
    public List<GlobalObject> findAll() throws UnsupportedEncodingException {
        return this.globalObjectService.findAll();

    }
}
