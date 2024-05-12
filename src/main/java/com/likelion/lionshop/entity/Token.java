package com.likelion.lionshop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "token")
public class Token {

    @Id
    private String email;

    private String token;

    @Builder
    public Token(String email, String token) {
        this.email = email;
        this.token = token;
    }
}
