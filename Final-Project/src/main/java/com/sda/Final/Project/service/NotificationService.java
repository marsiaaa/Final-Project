package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.MeetingDTO;
import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.entity.MeetingEntity;
import com.sda.Final.Project.entity.NotificationEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.NotificationMapper;
import com.sda.Final.Project.repository.MeetingRepository;
import com.sda.Final.Project.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService implements INotificationService {


    private final NotificationRepository notificationRepository;
    private final MeetingRepository meetingRepository;


    @Override
    public void save(NotificationDTO notificationDTO) {
        MeetingDTO meetingDTO = new MeetingDTO();

        Optional<MeetingEntity> meetingEntityOpt = meetingRepository
                .findById(notificationDTO.getMeeting().getId());

        if (!meetingEntityOpt.isPresent()) {
            throw new NotFoundException("Notification for this meeting cannot" +
                    " be created because meeting does not exist.");
        }
        if (notificationRepository.existsByMeetingId(notificationDTO.getMeeting().getId())) {
            throw new BadRequestException("Notification for this meeting already exists");
        }


        notificationRepository.save(NotificationMapper.toEntity(notificationDTO, meetingEntityOpt.get()));
    }


    @Override
    public List<NotificationDTO> findAllUser(Integer id) {
        List<NotificationEntity> notifications = notificationRepository
                .findAllByMeetingIdUserMeeting_Id(id);
        if (notifications.isEmpty()) {
            throw new BadRequestException("Notifications not found");
        }
        return notifications.stream()
                .map(NotificationMapper::toDTO)
                .toList();
    }

    @Override
    public List<NotificationDTO> findAllClient(Integer id) {
        List<NotificationEntity> notifications = notificationRepository
                .findAllByMeetingIdClientMeeting_Id(id);
        if (notifications.isEmpty()) {
            throw new BadRequestException("Notifications not found");
        }
        return notifications.stream()
                .map(NotificationMapper::toDTO)
                .toList();
    }


    @Override
    public void deleteByUserId(Integer Id) {
        List<NotificationEntity> notifications = notificationRepository.findAllByMeetingIdUserMeeting_Id(Id);

        if (!notifications.isEmpty()) {
            notificationRepository.deleteById(Id);
        } else {
            throw new NotFoundException("Notifications not found for user ID: " + Id);
        }
    }

    @Override
    public void deleteByClientId(Integer Id) {
        List<NotificationEntity> notifications = notificationRepository.findAllByMeetingIdClientMeeting_Id(Id);

        if (!notifications.isEmpty()) {
            notificationRepository.deleteById(Id);
        } else {
            throw new NotFoundException("Notifications not found for client ID: " + Id);
        }
    }

    @Override
    public void deleteAll() {

        long count = notificationRepository.count();

        if (count > 0) {
            notificationRepository.deleteAll();
        } else {
            throw new NotFoundException("No notifications found to delete.");
        }
    }
}




