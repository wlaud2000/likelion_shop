package com.likelion.lionshop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String address;

    @Builder
    public User(Long id, String userId, String name, String password, String address) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
    }

}
