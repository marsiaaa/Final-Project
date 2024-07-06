package com.sda.Final.Project.mapper;

import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.entity.UserEntity;

public class UserMapper {
    public static UserEntity toEntity(UserDTO userDTO) {
        return extractFields(userDTO, new UserEntity());
    }

    public static UserEntity toEntityForUpdate(UserDTO userDTO, UserEntity userEntity) {
        return extractFields(userDTO, userEntity);
    }
    public static UserDTO toDTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setName(userEntity.getName());
        userDTO.setSurname(userEntity.getSurname());
        userDTO.setEmail(userEntity.getEmail());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setDateCreated(userEntity.getDateCreated());
        userDTO.setDateModified(userEntity.getDateModified());
        userDTO.setLocation(userEntity.getLocation());
        userDTO.setFeedback(userEntity.getFeedback());
        userDTO.setRating(userEntity.getRating());
        return userDTO;
    }

    private static UserEntity extractFields(UserDTO userDTO, UserEntity userEntity) {
        userEntity.setId(userEntity.getId());
        userEntity.setName(userEntity.getName());
        userEntity.setSurname(userEntity.getSurname());
        userEntity.setEmail(userEntity.getEmail());
        userEntity.setPassword(userEntity.getPassword());
        userEntity.setDateCreated(userEntity.getDateCreated());
        userEntity.setDateModified(userEntity.getDateModified());
        userEntity.setLocation(userEntity.getLocation());
        userEntity.setFeedback(userEntity.getFeedback());
        userEntity.setRating(userEntity.getRating());
        return userEntity;
    }
}
