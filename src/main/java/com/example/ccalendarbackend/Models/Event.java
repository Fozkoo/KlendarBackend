package com.example.ccalendarbackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "event")
public class Event {
    @Id
    @Column(name = "idevent", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "hora", nullable = false)
    private LocalTime hora;

    @Column(name = "day", nullable = false)
    private LocalDate day;

    @Column(name = "iduser", nullable = false, length = 45)
    private String iduser;

}