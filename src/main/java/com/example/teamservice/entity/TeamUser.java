package com.example.teamservice.entity;

import com.example.teamservice.Enums.Status;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "TeamUser")
public class TeamUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id" )
    private Team team;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "join_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date joinDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_activity")
    private Date lastActivity;

}

