package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.dto.UserDTO;
import com.sda.Final.Project.service.INotificationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @PostMapping
    public void saveNotification(@RequestBody @Valid NotificationDTO notificationDTO) {
        notificationService.save(notificationDTO);
    }

    @GetMapping("/findAllByUser")
    public List<NotificationDTO> findAllByUserId(Integer userDTO) {
        return notificationService.findAll();
    }

    /*

    @GetMapping("/findAllByClient")
    public List<NotificationDTO> findAllByClient(@RequestParam Integer clientId) {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setId(clientId);
        return notificationService.findAll(clientDTO);
    }

    @DeleteMapping("/deleteByUser")
    public void deleteNotificationByUser(@RequestParam Integer id) {
        notificationService.delete(new UserDTO(id));
    }

    @DeleteMapping("/deleteByClient")
    public void deleteNotificationByClient(@RequestParam Integer id) {
        notificationService.delete(new ClientDTO(id));
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllNotifications() {
        notificationService.deleteAll();
    }

    @PutMapping("/update")
    public void updateNotification(@RequestBody NotificationDTO notificationDTO) {
        notificationService.update(notificationDTO);
    }

    @GetMapping("/findById")
    public NotificationDTO findNotificationById(@RequestParam Integer id) {
        return notificationService.findById(id);
    }

*/


}
