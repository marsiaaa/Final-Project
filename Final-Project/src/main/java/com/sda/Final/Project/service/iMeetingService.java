package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.MeetingDTO;

import java.util.List;

public interface iMeetingService {

    void save(MeetingDTO meetingDTO);
    void update(MeetingDTO meetingDTO);
    MeetingDTO findById(Integer id);
    List<MeetingDTO> findAll();
    void delete (Integer id);

    boolean canCreateMeeting(MeetingDTO meetingDTO);

    // boolean canCreateMeeting(MeetingDTO meetingDTO);
}
