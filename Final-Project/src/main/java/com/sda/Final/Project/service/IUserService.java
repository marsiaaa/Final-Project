package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.UserDTO;

import java.util.List;

public interface IUserService {
    void save(UserDTO userDTO);
    void update(UserDTO userDTO);
    void delete (Integer id);
    UserDTO findByEmail (String email);
    void deleteCurrentUser (String email);
}
