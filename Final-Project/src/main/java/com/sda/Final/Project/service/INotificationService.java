package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.dto.UserDTO;

import java.util.List;

public interface INotificationService {
    void save(NotificationDTO notificationDTO);
    List<NotificationDTO> findAll(UserDTO id);
    void delete (UserDTO Id);

    // restricted feature only for admin, TODO when implementing securiy
    List<NotificationDTO> deleteAll();
    void update(NotificationDTO notificationDTO);
    NotificationDTO findById(Integer id);
    Integer countNotifications(UserDTO userDTO);
    List<NotificationDTO> findByReadStatus(UserDTO userDTO, boolean read);
    List<NotificationDTO> findAll(UserDTO userDTO, int page, int size);





}
