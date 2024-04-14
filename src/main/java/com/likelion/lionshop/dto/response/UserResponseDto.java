package com.likelion.lionshop.dto.response;

import com.likelion.lionshop.entity.User;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserResponseDto {

    public String userId;

    public String name;

    public String password;

    public String address;

    @Builder
    public UserResponseDto(String userId, String name, String password, String address) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.address = address;
    }


    public static UserResponseDto toDto(User user) { //Entity -> DTO 변환 정적 메소드 사용으로 객체 생성을 위해 별도의 인스턴스를 생성할 필요가 없음
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .name(user.getName())
                .password(user.getPassword())
                .address(user.getAddress())
                .build();
    }


}
