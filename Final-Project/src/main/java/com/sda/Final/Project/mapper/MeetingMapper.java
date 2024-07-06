package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.MeetingDTO;
import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.entity.MeetingEntity;
import com.sda.Final.Project.entity.UserEntity;

public class MeetingMapper {

    public static MeetingEntity toEntity(MeetingDTO meetingDTO){
        return extractFrields(new MeetingEntity() , meetingDTO );
    }

    public static MeetingEntity toEntityForUpdate(MeetingDTO meetingDTO , MeetingEntity meetingEntity){
        return extractFrields(meetingEntity , meetingDTO);
    }

    public static MeetingDTO toDTO(MeetingEntity meetingEntity){
        MeetingDTO meetingDTO = new MeetingDTO();

        meetingDTO.setIdClientMeeting(ClientMapper.toDTO(meetingEntity.getIdClientMeeting()));
        meetingDTO.setIdUserMeeting(UserMapper.toDTO(meetingEntity.getIdUserMeeting()));

        return meetingDTO;
    }
    private static MeetingEntity extractFrields(MeetingEntity meetingEntity , MeetingDTO meetingDTO){
        UserEntity userEntity = UserMapper.toEntity(meetingDTO.getIdUserMeeting());
        ClientEntity clientEntity = ClientMapper.toEntity(meetingDTO.getIdClientMeeting());

        meetingEntity.setSubject(meetingDTO.getSubject());
        meetingEntity.setEndDateAndHour(meetingDTO.getEndDateAndHour());
        meetingEntity.setStartDateAndHour(meetingDTO.getStartDateAndHour());
        meetingEntity.setIdUserMeeting(userEntity);
        meetingEntity.setIdClientMeeting(clientEntity);

        return meetingEntity;
    }

}
