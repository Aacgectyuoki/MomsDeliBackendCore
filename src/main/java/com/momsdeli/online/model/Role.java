package com.momsdeli.online.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "roles")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    private String roleName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private List<User> users;
}


