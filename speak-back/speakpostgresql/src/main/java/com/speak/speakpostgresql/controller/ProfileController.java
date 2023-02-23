package com.speak.speakpostgresql.controller;

import com.speak.speakpostgresql.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping(path = "/save")
    public void addProfile(
            @RequestParam("name") String name,
            @RequestParam("lastName") String lastName,
            @RequestParam("description") String description,
            @RequestParam("email") String email,
            @RequestParam("age") String age) {
        this.profileService.addProfile(name, lastName, description, email, age);
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
