package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.MeetingDTO;
import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.entity.MeetingEntity;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.MeetingMapper;
import com.sda.Final.Project.repository.ClientRepository;
import com.sda.Final.Project.repository.UserRepository;
import com.sda.Final.Project.repository.MeetingRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@RequiredArgsConstructor
@Service
public class MeetingService implements iMeetingService{


    private final MeetingRepository meetingRepository;
    private final UserRepository userRepository;
    private final ClientRepository clientRepository;
    private final NotificationService notificationService;


    @Override
    public void save(MeetingDTO meetingDTO) {
        UserEntity userEntity = userRepository.findById(meetingDTO.getIdUserMeeting().getId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        ClientEntity clientEntity = clientRepository.findById(meetingDTO.getIdClientMeeting().getId())
                .orElseThrow(() -> new NotFoundException("Client not found"));



        if(meetingRepository.existsByStartDateAndEndDate(
                meetingDTO.getStartDateAndHour(), meetingDTO.getIdClientMeeting().getId(), meetingDTO.getIdUserMeeting().getId()
        )){
            throw new BadRequestException("You hava a scheduled meeting already");
        }

        MeetingEntity m = meetingRepository.save(MeetingMapper.toEntity(meetingDTO, userEntity, clientEntity));

        sendMail(m, "Meeting confirmation", "Dear %s,\nYour meeting is confirmed on" + m.getStartDate() + ".\nBest regards,\nSuperior Business Card Team");
    }

    private void sendMail(MeetingEntity m, String subject, String body) {
        MeetingDTO meetingDTOForNotif = new MeetingDTO();
        meetingDTOForNotif.setId(m.getId());

        NotificationDTO notificationDTO = new NotificationDTO();
        notificationDTO.setMeeting(meetingDTOForNotif);
        notificationDTO.setBody(body);
        notificationDTO.setSubject(subject);
        notificationDTO.setReceiver(m.getIdUserMeeting().getEmail());
        notificationDTO.setSender(m.getIdClientMeeting().getEmail());

        notificationService.save(notificationDTO);
    }

    @Override
    public void update(MeetingDTO meetingDTO) {

        UserEntity userEntity = userRepository.findById(meetingDTO.getIdUserMeeting().getId())
                .orElseThrow(() -> new NotFoundException("User not found"));

        ClientEntity clientEntity = clientRepository.findById(meetingDTO.getIdClientMeeting().getId())
                .orElseThrow(() -> new NotFoundException("Client not found"));


        Optional<MeetingEntity> meetingEntityOptional =
                meetingRepository.findById(meetingDTO.getId());

        if(meetingEntityOptional.isPresent()){
            MeetingEntity meetingEntity = meetingEntityOptional.get();
            meetingEntity = MeetingMapper.toEntityForUpdate(meetingDTO , meetingEntity, userEntity, clientEntity);

            meetingRepository.save(meetingEntity);
            sendMail(meetingEntity, "Meeting update", "Dear %s,\n\nYour meeting is confirmed on " + meetingEntity.getStartDate() + ".\nBest regards,\nSuperior Business Card Team");
        }else {
            throw new NotFoundException("Meeting cannot be found");
        }


    }

    @Override
    public MeetingDTO findById(Integer id) {

        Optional<MeetingEntity> meetingEntityOptional =
                meetingRepository.findById(id);
        if(meetingEntityOptional.isPresent()){
            MeetingEntity meetingEntity = meetingEntityOptional.get();
            return MeetingMapper.toDTO(meetingEntity);
        }else {
            throw new NotFoundException("You do not have a meeting in this time");
        }
    }

    @Override
    public List<MeetingDTO> findAll() {
        return meetingRepository.findAll().stream()
                .map(MeetingMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        meetingRepository.deleteById(id);
    }



}