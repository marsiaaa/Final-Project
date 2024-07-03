package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping
    public void save(@RequestBody @Valid UserDTO userDTO) {
        iUserService.save(userDTO);
    }

    @PutMapping
    public void update(@RequestBody @Valid UserDTO authorDTO) {
        iUserService.update(authorDTO);
    }


}
