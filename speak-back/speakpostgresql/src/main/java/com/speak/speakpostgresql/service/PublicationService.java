package com.speak.speakpostgresql.service;

import com.speak.speakpostgresql.model.Publication;
import com.speak.speakpostgresql.repository.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PublicationService {
    @Value("${download.folder}")
    private String downloadFolder;
    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public void addPub(Publication pub) {
        this.publicationRepository.save(pub);
    }

    public void deletePub(String id) {
        this.publicationRepository.deleteById(id);
    }

    public List<Publication> getAll() {
        return this.publicationRepository.findAll();
    }

    public void download(MultipartFile file, String description, String owner, String type) throws IOException {
        byte[] data = file.getBytes();


        Publication newPub = new Publication(file.getOriginalFilename(),
                description,
                type,
                downloadFolder + file.getOriginalFilename(),
                owner);
        addPub(newPub);
        Path path = Paths.get(downloadFolder + file.getOriginalFilename());
        Files.write(path, data);

    }
}
