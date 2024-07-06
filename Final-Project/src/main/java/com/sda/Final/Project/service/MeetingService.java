package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.MeetingDTO;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@RequiredArgsConstructor
@Service
public class MeetingService implements iMeetingService{

    //@Autowired
    private final MeetingRepository meetingRepository;
  //  @Autowired
    private final UserRepository userRepository;
   // @Autowired
    private final ClientRepository clientRepository;


    @Override
    public void save(MeetingDTO meetingDTO) {
        List<ClientEntity> clientEntityList = clientRepository
                .findAllByName(meetingDTO.getIdClientMeeting().getName());
        List<UserEntity> userEntityList = userRepository
                .findAllByName(meetingDTO.getIdUserMeeting().getName());

        LocalDateTime startDateTime = meetingDTO.getStartDateAndHour();
        LocalDateTime endDateTime = meetingDTO.getEndDateAndHour();


        if(!clientEntityList.isEmpty() && !userEntityList.isEmpty() ){
            if(startDateTime.equals()){
                throw new BadRequestException("You hava a scheduled meeting already");
            }
        }
        meetingRepository.save(MeetingMapper.toEntity(meetingDTO));
    }

    @Override
    public void update(MeetingDTO meetingDTO) {
        Optional<MeetingEntity> meetingEntityOptional =
                meetingRepository.findById(meetingDTO.getId());

        if(meetingEntityOptional.isPresent()){
            MeetingEntity meetingEntity = meetingEntityOptional.get();
            meetingEntity = MeetingMapper.toEntityForUpdate(meetingDTO , meetingEntity);

            meetingRepository.save(meetingEntity);
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

    @Override
    public boolean canCreateMeeting(MeetingDTO meetingDTO) {
       // if (meetingRepository.existsByStartDateAndEndDate(
        //      meetingDTO.getStartDateAndHour(), meetingDTO.getEndDateAndHour())) {
           // throw new BadRequestException("A meeting with the same start and end time already exists.");
      //  }

       // meetingRepository.save(MeetingMapper.toEntity(meetingDTO));
        return false;
    }
}
