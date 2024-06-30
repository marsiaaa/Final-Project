package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.UserDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements IUserService{


    @Override
    public void save(UserDTO userDTO) {

    }

    @Override
    public void update(UserDTO userDTO) {

    }

    @Override
    public UserDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<UserDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
