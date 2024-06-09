package com.example.pontejavabackendtask.Entity;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "contacts")
public class ContactEntity {
     @Id
     @SequenceGenerator(name = "seq_history", sequenceName = "seq_history_id", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;

     @Setter
     @Column(nullable = false)
     private String name;

     @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
     private List<EmailEntity> emails;

     @OneToMany(mappedBy = "contact",cascade = CascadeType.ALL)
     private List<AddressEntity> address;
}