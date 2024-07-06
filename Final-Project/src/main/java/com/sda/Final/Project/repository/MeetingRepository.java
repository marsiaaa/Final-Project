package com.sda.Final.Project.repository;

import com.sda.Final.Project.entity.MeetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingEntity , Integer> {
       // List<MeetingEntity> findAllBySubject();
       // boolean existsByStartDateAndHourAndEndDateAndHour(LocalDateTime startDateAndHour, LocalDateTime endDateAndHour);
}
