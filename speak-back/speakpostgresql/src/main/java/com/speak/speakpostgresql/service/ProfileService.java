package com.speak.speakpostgresql.service;

import com.speak.speakpostgresql.model.Profile;
import com.speak.speakpostgresql.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public void addProfile(String name,String lastName,String description,String email,String age) {
        Profile p =new Profile(name,description,"profile",lastName,email,Integer.parseInt(age));
        this.profileRepository.save(p);
    }

    public void deleteProfile(String id) {
        this.profileRepository.deleteById(id);
    }

    public List<Profile> getAll() {
        return this.profileRepository.findAll();
    }
}
