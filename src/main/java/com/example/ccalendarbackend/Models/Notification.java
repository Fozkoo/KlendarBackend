package com.example.ccalendarbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @Column(name = "idnotification", nullable = false)
    private Integer id;

    @Column(name = "type", nullable = false, length = 45)
    private String type;

}