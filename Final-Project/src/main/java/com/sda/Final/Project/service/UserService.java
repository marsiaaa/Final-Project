package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.entity.UserEntity;
import com.sda.Final.Project.exception.BadRequestException;
import com.sda.Final.Project.exception.NotFoundException;
import com.sda.Final.Project.mapper.UserMapper;
import com.sda.Final.Project.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService{
    private final UserRepository userRepository;

    @Override
    public void save(UserDTO userDTO) {
        if (!userRepository.findAllByName(userDTO.getName()).isEmpty()) {
            throw new BadRequestException("This user already exists");
        }
        userRepository.save(UserMapper.toEntity(userDTO));
    }
    @Override
    public void update(UserDTO userDTO) {
        Optional<UserEntity> userEntity = userRepository.findById(userDTO.getId());

        if (userEntity.isPresent()) {
            UserEntity userToUpdate = userEntity.get();
            userToUpdate = UserMapper.toEntityForUpdate(userDTO, userToUpdate);
            userRepository.save(userToUpdate);
        } else {
            throw new NotFoundException("User not found");
        }
    }
    @Override
    public void delete(Integer id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new NotFoundException("User not found");

        }
    }
    @Override
    public UserDTO findByEmail(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByEmail(email);

        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            return UserMapper.toDTO(userEntity);
        } else {
            throw new NotFoundException("User not found with email: " + email);
        }
    }

    @Override
    public void deleteCurrentUser(String email) {
        Optional<UserEntity> userEntityOptional = userRepository.findUserEntityByEmail(email);

        if (userEntityOptional.isPresent()) {
            UserEntity userEntity = userEntityOptional.get();
            userRepository.delete(userEntity);
        } else {
            throw new NotFoundException("User not found with email: " + email);
        }
    }
}
