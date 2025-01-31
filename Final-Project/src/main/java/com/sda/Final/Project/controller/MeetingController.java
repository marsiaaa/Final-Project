package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.MeetingDTO;
import com.sda.Final.Project.service.MeetingService;
import com.sda.Final.Project.service.iMeetingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meeting")
public class MeetingController {

    @Autowired
    private iMeetingService iMeetingService;

    @PostMapping
    public void save(@RequestBody @Valid  MeetingDTO meetingDTO){
        iMeetingService.save(meetingDTO);
    }

    @GetMapping("/{id}")
    public MeetingDTO findById(@PathVariable ("id")Integer id){
        return iMeetingService.findById(id);
    }

    @GetMapping
    public List<MeetingDTO> findAll(){
        return iMeetingService.findAll();
    }

    @PutMapping
    public void update(@RequestBody @Valid MeetingDTO meetingDTO){
        iMeetingService.update(meetingDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        iMeetingService.delete(id);
    }
}
