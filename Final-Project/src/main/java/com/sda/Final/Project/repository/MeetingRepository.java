package com.sda.Final.Project.repository;

import com.sda.Final.Project.entity.MeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MeetingRepository extends JpaRepository<MeetingEntity , Integer> {
       // List<MeetingEntity> findAllBySubject();
//       boolean existsByStartDateAndEndDateAndIdClientMeeting_IdAndIdUserMeeting_Id(LocalDateTime startDate, LocalDateTime endDate, Integer clientId, Integer userId);

       @Query("select case when count(m) > 0 then true else false end from MeetingEntity m where m.startDate <= :startDate and m.endDate>= :startDate and m.idUserMeeting.id = :userId and m.idClientMeeting.id = :clientId")
       boolean existsByStartDateAndEndDate(LocalDateTime startDate,  Integer clientId, Integer userId);
}
