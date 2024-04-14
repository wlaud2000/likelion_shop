package com.likelion.lionshop.dto.request;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //매개변수 없는 생성자를 생성해 줍니다.
@Getter //모든 필드의 Getter 메서드를 자동으로 생성해줍니다.
public class UpdateUserRequestDto {

    public String name;

    public String userId;

    public String password;

    public String address;

    @Builder
    public UpdateUserRequestDto(String name, String userId, String password, String address) {
        this.name = name;
        this.userId = userId;
        this.password = password;
        this.address = address;
    }
}
