package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.SocialMediaDTO;
import com.sda.Final.Project.entity.SocialMediaEntity;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.SocialMediaMapper;
import com.sda.Final.Project.repository.SocialMediaRepository;
import com.sda.Final.Project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class SocialMediaService implements ISocialMediaService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SocialMediaRepository socialMediaRepository;


    @Override
    public void save(SocialMediaDTO socialMediaDTO) {
        Optional<UserEntity> userEntityOpt = userRepository.
                findById(
                        socialMediaDTO.getUserDTO().getId()
                );
        if (userEntityOpt.isPresent()){
            SocialMediaEntity socialMediaEntity = SocialMediaMapper.toEntity(socialMediaDTO,userEntityOpt.get());
            socialMediaRepository.save(socialMediaEntity);
        } else {
            throw new NotFoundException("User not found for these accounts");
        }

    }

    @Override
    public void update(SocialMediaDTO socialMediaDTO) {
        Optional<UserEntity> userEntityOpt = userRepository.
                findById(
                        socialMediaDTO.getUserDTO().getId()
                );
        Optional<SocialMediaEntity> socialMediaEntityOptional = socialMediaRepository
                .findById(
                        socialMediaDTO.getId()
                );
        if (userEntityOpt.isPresent()&& socialMediaEntityOptional.isPresent()){
            SocialMediaEntity socialMediaEntity = SocialMediaMapper.toEntityForUpdate(socialMediaEntityOptional.get(),
                    socialMediaDTO,userEntityOpt.get());
            socialMediaRepository.save(socialMediaEntity);
        }else {
            throw new BadRequestException("User or accounts not found");
        }
    }

    @Override
    public SocialMediaDTO findById(Integer id) {
        Optional<SocialMediaEntity> socialMediaEntityOp = socialMediaRepository.findById(id);
        if (socialMediaEntityOp.isPresent()){
            return SocialMediaMapper.toDTO(socialMediaEntityOp.get());
        }else {
            throw  new NotFoundException("Account not found");
        }

    }

    @Override
    public List<SocialMediaDTO> findAll() {
        return  socialMediaRepository.findAll().stream().map(SocialMediaMapper::toDTO).toList();

    }

    @Override
    public void delete(Integer id) {
        socialMediaRepository.deleteById(id);

    }
}
