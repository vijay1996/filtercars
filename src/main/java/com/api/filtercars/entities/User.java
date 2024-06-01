package com.api.filtercars.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Timestamp;
import java.time.ZoneId;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long id;

    @Column
    private String name;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    @CurrentTimestamp
    private Timestamp creationTimestamp;

    @Column
    @CurrentTimestamp
    private Timestamp updationTimestamp;
}
