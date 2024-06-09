package com.example.pontejavabackendtask.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "emails")
public class EmailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Setter
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "contact_id", nullable = false)
    private ContactEntity contact;

    @Setter
    @Column(nullable = false)
    private String email;

}