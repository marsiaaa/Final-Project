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
    public void save(@RequestBody UserDTO userDTO) {
        iUserService.save(userDTO);
    }

    @PutMapping
    public void update(@RequestBody UserDTO authorDTO) {
        iUserService.update(authorDTO);
    }
    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Integer id) {
        iUserService.delete(id);
    }
    @DeleteMapping("/{email}")
    public void deleteByEmail(@PathVariable String email) {
        iUserService.deleteCurrentUser(email);
    }
    @GetMapping("/{email}")
    public UserDTO findByEmail(@PathVariable String email) {
        return iUserService.findByEmail(email);
    }

//    {
//        "name" : "testname",
//            "surname" : "testsurname",
//            "email": "user@gmail.com",
//            "password": "testpassword",
//            "dateCreated" : "2024-09-09",
//            "dateModified" : "2024-10-10",
//            "location": "testlocation",
//            "feedback" : "testfeedback",
//            "rating": 2
//    }
}
