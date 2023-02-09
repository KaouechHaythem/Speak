package com.speak.speakpostgresql.controller;

import com.speak.speakpostgresql.model.Profile;
import com.speak.speakpostgresql.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    /**
     * save a profile
     *
     * @param profile
     */
    @PostMapping(path = "/save")
    public void addProfile(@RequestBody Profile profile) {
        this.profileService.addProfile(profile);
    }

    /**
     * delete a profile
     *
     * @param id
     */
    @DeleteMapping(path = "/{id}")
    public void deleteProfile(@PathVariable(name = "id") String id) {
        this.profileService.deleteProfile(id);
    }
}
