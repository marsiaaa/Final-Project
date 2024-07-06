package com.sda.Final.Project.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Notification")
public class NotificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "sender")
    private String sender;
    @Column(name = "receiver")
    private String receiver;
    @Column(name = "carbon_copy")
    private String carbon_copy;
    @Column(name = "subject")
    private String subject;
    @Column(name = "body")
    private String body;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_meeting_notification", referencedColumnName = "id")
    private MeetingEntity meeting;


}

