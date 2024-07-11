package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.MeetingDTO;
import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.entity.MeetingEntity;
import com.sda.Final.Project.entity.UserEntity;

public class MeetingMapper {

    public static MeetingEntity toEntity(MeetingDTO meetingDTO, UserEntity userEntity, ClientEntity clientEntity){
        return extractFields(new MeetingEntity() , meetingDTO , userEntity, clientEntity);
    }

    public static MeetingEntity toEntityForUpdate(MeetingDTO meetingDTO , MeetingEntity meetingEntity,UserEntity userEntity, ClientEntity clientEntity){
        return extractFields(meetingEntity , meetingDTO, userEntity, clientEntity);
    }

    public static MeetingDTO toDTO(MeetingEntity meetingEntity){
        MeetingDTO meetingDTO = new MeetingDTO();
        meetingDTO.setId(meetingEntity.getId());
        meetingDTO.setIdClientMeeting(ClientMapper.toDTO(meetingEntity.getIdClientMeeting()));
        meetingDTO.setIdUserMeeting(UserMapper.toDTO(meetingEntity.getIdUserMeeting()));
        meetingDTO.setSubject(meetingEntity.getSubject());
        meetingDTO.setEndDateAndHour(meetingEntity.getEndDate());
        meetingDTO.setStartDateAndHour(meetingEntity.getStartDate());
        return meetingDTO;
    }
    private static MeetingEntity extractFields(MeetingEntity meetingEntity , MeetingDTO meetingDTO, UserEntity userEntity, ClientEntity clientEntity){

        meetingEntity.setSubject(meetingDTO.getSubject());
        meetingEntity.setEndDate(meetingDTO.getEndDateAndHour());
        meetingEntity.setStartDate(meetingDTO.getStartDateAndHour());
        meetingEntity.setIdUserMeeting(userEntity);
        meetingEntity.setIdClientMeeting(clientEntity);

        return meetingEntity;
    }

}
