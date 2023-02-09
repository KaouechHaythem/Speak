package com.speak.speakpostgresql.service;

import com.speak.speakpostgresql.model.GlobalObject;
import com.speak.speakpostgresql.repository.GlobalObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Service
public class GlobalObjectService {
    GlobalObjectRepository globalObjectRepository;
    @Autowired
    private RestGateService restGateService;

    @Autowired
    public GlobalObjectService(GlobalObjectRepository globalObjectRepository) {
        this.globalObjectRepository = globalObjectRepository;
    }

    public List<GlobalObject> search(String searchTerm) throws UnsupportedEncodingException {
        return this.restGateService.search(searchTerm);

    }

    public List<GlobalObject> findAll() {
        return this.globalObjectRepository.findAll();
    }
}
