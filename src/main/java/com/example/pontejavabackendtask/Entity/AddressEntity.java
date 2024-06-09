package com.example.pontejavabackendtask.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "addresses")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonBackReference
    @Setter
    @JoinColumn(name = "contact_id", nullable = false)
    private ContactEntity contact;

    @Setter
    @Column(nullable = false)
    private String address;
}