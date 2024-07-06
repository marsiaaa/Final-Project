package com.sda.Final.Project.repository;

import com.sda.Final.Project.entity.ClientEntity;
import com.sda.Final.Project.entity.NotificationEntity;
import com.sda.Final.Project.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationEntity, Integer> {

    //List<NotificationEntity> findAllByEmail(String email);

   List<NotificationEntity> findAllByUserId(Integer id);
   // List<NotificationEntity>findAllByClientId(Integer id);

    boolean existsByMeetingId(Integer id);

   // Integer countByReceiver(UserEntity userEntity);

   // Integer countBySender(ClientEntity clientEntity);

    //List<NotificationEntity> findByReceiverAndRead(UserEntity userEntity, boolean read);

   // List<NotificationEntity> findBySenderAndRead(ClientEntity clientEntity, boolean read);

}

