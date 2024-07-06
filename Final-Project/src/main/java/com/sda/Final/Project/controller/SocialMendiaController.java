package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.SocialMediaDTO;
import com.sda.Final.Project.service.ISocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socialMedia")
public class SocialMendiaController {


    @Autowired
    private ISocialMediaService iSocialMediaService;

    @PostMapping
    private void save (@RequestBody SocialMediaDTO socialMediaDTO){
        iSocialMediaService.save(socialMediaDTO);
    }

    @PutMapping
    public void update(@RequestBody SocialMediaDTO socialMediaDTO){
        iSocialMediaService.update(socialMediaDTO);
    }


    @GetMapping("/{id}")
    public SocialMediaDTO findById(@PathVariable Integer id){
        return iSocialMediaService.findById(id);
    }
    @GetMapping
    public List<SocialMediaDTO> findAll() {
        return iSocialMediaService.findAll();

    }
    @DeleteMapping("/{id}")
    public void delete (@PathVariable("id") Integer id) {
        iSocialMediaService.delete(id);
    }

}
