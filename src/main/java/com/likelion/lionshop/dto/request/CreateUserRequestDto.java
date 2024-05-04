package com.likelion.lionshop.dto.request;

import com.likelion.lionshop.entity.User;
import lombok.*;

@NoArgsConstructor //매개변수 없는 생성자를 생성해 줍니다.
@Getter //모든 필드의 Getter 메서드를 자동으로 생성해줍니다.
public class CreateUserRequestDto {

    public String name;

    public String userId;

    public String password;

    public String address;

    @Builder
    public CreateUserRequestDto(String name, String userId, String password, String address) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.address = address;
    }

    //DTO를 Entity로 변환하는 메서드
    public User toEntity() {
        return User.builder()
                .name(name)
                .userId(userId)
                .password(password)
                .address(address)
                .build();
    }
}
