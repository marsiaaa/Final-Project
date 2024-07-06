package com.sda.Final.Project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "Meeting")
@Data
public class MeetingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "subject")
    private String subject;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user_meeting",referencedColumnName = "id")
    private UserEntity idUserMeeting;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_client_meeting",referencedColumnName = "id")
    private ClientEntity idClientMeeting;

}
