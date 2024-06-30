package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.UserDTO;

import java.util.List;

public interface IUserService {
    void save(UserDTO userDTO);
    void update(UserDTO userDTO);
    UserDTO findById(Integer id);
    List<UserDTO> findAll();

    void delete (Integer id);
}
