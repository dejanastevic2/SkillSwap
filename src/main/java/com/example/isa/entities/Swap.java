package com.example.isa.entities;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table

public class Swap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sender_id")
    private Integer senderId;

    @Column(name = "receiver_id")
    private Integer receiverId;

    @Column(name = "skill_id")
    private Integer skillId;

    @Column(name = "status")
    private String status;

    @Column(name = "scheduled_date")
    private LocalDateTime scheduledDate;
}

