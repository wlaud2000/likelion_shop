package com.likelion.lionshop.dto.response;

import com.likelion.lionshop.entity.User;
import lombok.*;

@Getter
@NoArgsConstructor
public class UserResponseDto {

    public String email;

    public String name;

    public String password;

    public String address;

    @Builder
    public UserResponseDto(String email, String name, String password, String address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.address = address;
    }


    public static UserResponseDto from(User user) { //Entity -> DTO 변환 정적 메소드 사용으로 객체 생성을 위해 별도의 인스턴스를 생성할 필요가 없음, toDto에서 from으로 메소드 이름 변경
        return UserResponseDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .address(user.getAddress())
                .build();
    }


}
