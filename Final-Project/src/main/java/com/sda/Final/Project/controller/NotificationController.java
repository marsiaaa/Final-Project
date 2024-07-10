package com.sda.Final.Project.controller;

import com.sda.Final.Project.dto.NotificationDTO;
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
    @GetMapping("/findAllByUser/{id}")
    public List<NotificationDTO> findAllByUserId(@PathVariable Integer id) {
        return notificationService.findAllUser(id);
    }

    @GetMapping("/findAllByClient/{id}")
    public List<NotificationDTO> findAllByClientId(@PathVariable Integer id) {
        return notificationService.findAllClient(id);
    }
    @DeleteMapping("/deleteByUser/{id}")
    public void deleteNotificationByUser(@PathVariable Integer id) {
        notificationService.deleteByUserId(id);
    }
    @DeleteMapping("/deleteByClient/{id}")
    public void deleteNotificationByClient(@PathVariable Integer id) {
        notificationService.deleteByClientId(id);
    }
    @DeleteMapping("/deleteAll")
    public void deleteAllNotifications() {
        notificationService.deleteAll();
    }

}

