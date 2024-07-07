package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.UploadDto;
import com.sda.Final.Project.entity.UploadEntity;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.UploadMapper;
import com.sda.Final.Project.repository.UploadRepository;
import com.sda.Final.Project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UploadService implements iUploadService{

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UploadRepository uploadRepository;

    @Override
    public void save(UploadDto uploadDto) {
        Optional<UserEntity> userEntityOptional = userRepository
                .findById(uploadDto.getIdUserUpload().getId());

        if(!userEntityOptional.isPresent()){
            throw new NotFoundException("The photo is being uploaded");
        }

        if(uploadRepository.existsById(uploadDto.getIdUserUpload().getId())){
            throw new BadRequestException("This user has already uploaded  a photo");
        }

        uploadRepository.save(UploadMapper.toEntity(uploadDto , userEntityOptional.get()));
    }

    @Override
    public UploadDto findById(Integer id) {
        Optional<UploadEntity> uploadEntityOptional =
                uploadRepository.findById(id);

        if (uploadEntityOptional.isPresent()){
            UploadEntity uploadEntity = uploadEntityOptional.get();
            return UploadMapper.toDTO(uploadEntity);
        }else {
            throw  new NotFoundException("Photo with id"+id+"cannot be found");
        }
    }


    @Override
    public void delete(Integer id) {
        uploadRepository.deleteById(id);
    }

    @Override
    public List<UploadDto> findAllByUserId(Integer userId) {
        return uploadRepository.findAllByIdUserUpload_Id(userId).stream().map(UploadMapper::toDTO).collect(Collectors.toList());
    }
}
