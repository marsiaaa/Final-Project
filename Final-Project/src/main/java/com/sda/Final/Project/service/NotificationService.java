package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.dto.MeetingDTO;
import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.entity.MeetingEntity;
import com.sda.Final.Project.entity.NotificationEntity;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.NotificationMapper;
import com.sda.Final.Project.repository.ClientRepository;
import com.sda.Final.Project.repository.MeetingRepository;
import com.sda.Final.Project.repository.NotificationRepository;
import com.sda.Final.Project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService implements INotificationService {

    @Autowired
    private final NotificationRepository notificationRepository;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final MeetingRepository meetingRepository;
    @Autowired
    private final ClientRepository clientRepository;


    @Override
    public void save(NotificationDTO notificationDTO) {
        MeetingDTO meetingDTO = new MeetingDTO();

        Optional<MeetingEntity> meetingEntityOpt = meetingRepository
                .findById(notificationDTO.getMeeting().getId());

        if (!meetingEntityOpt.isPresent()){
            throw new NotFoundException("Notification for this meeting cannot" +
                    " be created because meeting does not exist.");
        }
        if (notificationRepository.existsByMeetingId(notificationDTO.getMeeting().getId())) {
            throw new BadRequestException("Notification for this meeting already exists");
        }


        notificationRepository.save(NotificationMapper.toEntity(notificationDTO, meetingEntityOpt.get()));
    }



    @Override
    public List<NotificationDTO> findAll(UserDTO userDTO) {
        List<NotificationEntity> notifications = notificationRepository.findAllByUserId(userDTO.getId());
        if (notifications.isEmpty()){
            throw new BadRequestException("Notifications not found");
        }
        return notifications.stream()
                .map(NotificationMapper::toDTO)
                .toList();
    }

}

    /*

    @Override
    public List<NotificationDTO> findAll(ClientDTO clientDTO) {
        List<NotificationEntity> notifications = notificationRepository.findAllByClientId(clientDTO.getId());
        return notifications.stream()
                .map(NotificationMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public void delete(UserDTO Id) {
        Optional<NotificationEntity> notificationEntity = notificationRepository.findById(Id.getId());
        if (notificationEntity.isPresent()) {
            notificationRepository.deleteById(Id.getId());
        } else {
            throw new NotFoundException("Notification not found!");
        }
    }

    @Override
    public void delete(ClientDTO Id) {
        Optional<NotificationEntity> notificationEntity = notificationRepository.findById(Id.getId());
        if (notificationEntity.isPresent()) {
            notificationRepository.deleteById(Id.getId());
        } else {
            throw new NotFoundException("Notification not found!");
        }
    }

    @Override
    public void deleteAll() {
        if (notificationRepository.count() > 0) {
            notificationRepository.deleteAll();
        } else {
            throw new NotFoundException("No notifications found to delete.");
        }

    }

    @Override
    public void update(NotificationDTO notificationDTO) {
        Optional<NotificationEntity> notificationEntity = notificationRepository.findById(notificationDTO.getId());

        if (notificationEntity.isPresent()) {
            NotificationEntity notificationToUpdate = notificationEntity.get();
            notificationToUpdate = NotificationMapper.toEntityForUpdate(notificationDTO, notificationToUpdate);
            notificationRepository.save(notificationToUpdate);
        } else {
            throw new NotFoundException("Notification not found!");

        }

    }

    @Override
    public NotificationDTO findById(Integer id) {
        Optional<NotificationEntity> notificationEntity = notificationRepository.findById(id);
        if (notificationEntity.isPresent()) {
            return NotificationMapper.toDTO(notificationEntity.get());
        } else {
            throw new NotFoundException("Notification not found!");
        }
    }


    @Override
    public Integer countNotifications(UserDTO userDTO, ClientDTO clientDTO) {
        Optional<UserEntity> userOptional = userRepository.findById(userDTO.getId());

        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();

            return notificationRepository.countByReceiver(userEntity);
        } else {

            Optional<ClientEntity> clientOptional = clientRepository.findById(clientDTO.getId());

            if (clientOptional.isPresent()) {
                ClientEntity clientEntity = clientOptional.get();

                return notificationRepository.countBySender(clientEntity);
            } else {
                throw new NotFoundException("User or Client not found");
            }
        }
    }
}



/*    @Override
    public List<NotificationDTO> findByReadStatus(UserDTO userDTO, boolean read) {
        if (userDTO != null) {
            Optional<UserEntity> userOptional = userRepository.findById(userDTO.getId());

            if (userOptional.isPresent()) {
                UserEntity userEntity = userOptional.get();
                List<NotificationEntity> notificationEntityList = notificationRepository.findByReceiverAndRead(userEntity, read);
                return NotificationMapper.toDTOList(notificationEntityList);
            } else {
                throw new NotFoundException("User not found");
            }
        } else {
            throw new BadRequestException("UserDTO must be provided");
        }
    }
    @Override
    public List<NotificationDTO> findByReadStatus(ClientDTO clientDTO, boolean read) {
        if (clientDTO != null) {
            Optional<ClientEntity> clientOptional = clientRepository.findById(clientDTO.getId());

            if (clientOptional.isPresent()) {
                ClientEntity clientEntity = clientOptional.get();
                List<NotificationEntity> notificationEntities = notificationRepository.findBySenderAndRead(clientEntity, read);
                return NotificationMapper.toDTOList(notificationEntities);
            } else {
                throw new NotFoundException("Client not found");
            }
        } else {
            throw new BadRequestException("ClientDTO must be provided");
        }
    }


  //  @Override
    //public List<NotificationDTO> findAll(UserDTO userDTO, int page, int size) {
    // TODO find a way to implement number of pages with notification for user and client!

    public List <NotificationEntity> createMeetingConfirmationNotification(ClientEntity client, UserEntity user, MeetingEntity meeting) {
        List<NotificationEntity> notifications = new ArrayList<>();

        NotificationEntity clientNotification = new NotificationEntity();
        clientNotification.setSender("noreply@superiorbusinesscard.com");
        clientNotification.setReceiver(client.getEmail());
        clientNotification.setSubject("Meeting Confirmation");
        clientNotification.setBody(String.format("Dear %s,\n\nYour meeting is confirmed at %s on %s.\n\nBest regards,\nSuperior Business Card Team",
                client.getName(), meeting.getStartDateAndHour(), meeting.getEndDateAndHour()));

        notifications.add(clientNotification);

        NotificationEntity userNotification = new NotificationEntity();
        userNotification.setSender("noreply@superiorbusinesscard.com");
        userNotification.setReceiver(user.getEmail());
        userNotification.setSubject("Meeting Confirmation");
        userNotification.setBody(String.format("Dear %s,\n\nYour meeting is confirmed at %s on %s.\n\nBest regards,\nSuperior Business Card Team",
                user.getName(), meeting.getStartDateAndHour(), meeting.getEndDateAndHour()));

        notifications.add(userNotification);
        return notifications;
    }

    // TODO check sepse nje logjike e ngjashme na duhet dhe te meeting!


}
*/




