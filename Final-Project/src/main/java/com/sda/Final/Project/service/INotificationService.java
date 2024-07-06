package com.sda.Final.Project.service;

import com.sda.Final.Project.dto.ClientDTO;
import com.sda.Final.Project.dto.NotificationDTO;
import com.sda.Final.Project.dto.UserDTO;

import java.util.List;

public interface INotificationService {
    void save(NotificationDTO notificationDTO);
   List<NotificationDTO> findAll(UserDTO userDTO);

   // List<NotificationDTO> findAll(ClientDTO clientDTO);

   // void delete (UserDTO Id);

    //void delete(ClientDTO Id);

    // restricted feature only for admin, TODO when implementing securiy
   // void deleteAll();
   // void update(NotificationDTO notificationDTO);
  //  NotificationDTO findById(Integer id);
   // Integer countNotifications(UserDTO userDTO, ClientDTO clientDTO);

   // List<NotificationDTO> findByReadStatus(UserDTO userDTO, boolean read);

   // List<NotificationDTO> findByReadStatus(ClientDTO clientDTO, boolean read);

    //List<NotificationDTO> findAll(UserDTO userDTO, int page, int size);





}
