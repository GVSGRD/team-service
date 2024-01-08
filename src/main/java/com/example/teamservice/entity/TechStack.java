package com.example.teamservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TechStack")
public class TechStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String technology;

    private long teamId;
}
