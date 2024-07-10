package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.dto.UserDTO;

import java.util.List;

public interface INotificationService {
    void save(NotificationDTO notificationDTO);
    List<NotificationDTO> findAllUser(Integer id);

    List<NotificationDTO> findAllClient(Integer id);
    void deleteByUserId (Integer id);
    void deleteByClientId(Integer id);

    // restricted feature only for admin, TODO when implementing securiy
    void deleteAll();

    //Integer countNotifications (Integer id);

    //Integer countNotifications(UserDTO userDTO);






}
