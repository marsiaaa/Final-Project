package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.entity.NotificationEntity;

public class NotificationMapper {
    public static NotificationEntity toEntity(NotificationDTO notificationDTO) {
        return extractFields(notificationDTO, new NotificationEntity());
    }

    public static NotificationEntity toEntityForUpdate(NotificationDTO notificationDTO, NotificationEntity notification) {
        return extractFields(notificationDTO, notification);
    }
   // public NotificationEntity toEntity(NotificationDTO notificationDTO, MeetingDTO meetingDTO) {
       // return extractFields(notificationDTO, new NotificationEntity(), meetingDTO, new MeetingEntity);
   // }
    public static NotificationDTO toDTO(NotificationEntity notification) {
        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setId(notification.getId());
        notificationDTO.setSender(notification.getSender());
        notificationDTO.setReceiver(notification.getReceiver());
        notificationDTO.setCarbon_copy(notification.getCarbon_copy());
        notificationDTO.setBody(notification.getBody());
        notificationDTO.setSubject(notification.getSubject());
        //authorBookDTO.setAuthor(AuthorMapper.toDTO(authorBook.getAuthor()));
        //authorBookDTO.setBook(BookMapper.toDTO(authorBook.getBook()));
        return notificationDTO;
    }

    private static NotificationEntity extractFields(NotificationDTO notificationDTO, NotificationEntity notification) {

        //MeetingEntity meetingEntity = MeetingMapper.toEntity(meetingDTO.getMeeting());

        //meetingEntity.setMeeting(meeting);

        notification.setId(notificationDTO.getId());
        notification.setSender(notificationDTO.getSender());
        notification.setReceiver(notificationDTO.getReceiver());
        notification.setCarbon_copy(notificationDTO.getCarbon_copy());
        notification.setBody(notificationDTO.getBody());
        notification.setSubject(notificationDTO.getSubject());

        return notification;
    }
}
