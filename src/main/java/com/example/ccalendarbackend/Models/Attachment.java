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
@Table(name = "attachments")
public class Attachment {
    @Id
    @Column(name = "idattachments", nullable = false)
    private Integer id;

    @Column(name = "url", nullable = false, length = 45)
    private String url;

}