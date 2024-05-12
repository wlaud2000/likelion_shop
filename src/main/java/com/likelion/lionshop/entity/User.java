package com.likelion.lionshop.entity;

import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String roles;

    @Column
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> order;

    @Builder
    protected User(Long id, String email, String name, String password, String address, String roles,List<Order> order) { //캡슐화 유지. protected로 외부 클래스에서 직접 인스턴스화할 수 없개 작성
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
        this.roles = roles;
        this.order = order;
    }

    public void update(UpdateUserRequestDto updateUserRequestDto) {
        name = updateUserRequestDto.getName();
        password = updateUserRequestDto.getPassword();
        address = updateUserRequestDto.getAddress();
    }

}
