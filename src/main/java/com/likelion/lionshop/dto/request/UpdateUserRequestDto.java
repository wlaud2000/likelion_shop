package com.likelion.lionshop.dto.request;

import lombok.*;

@NoArgsConstructor //매개변수 없는 생성자를 생성해 줍니다.
@Getter //모든 필드의 Getter 메서드를 자동으로 생성해줍니다.
public class UpdateUserRequestDto {

    public String name;

    public String password;

    public String address;

    @Builder
    public UpdateUserRequestDto(String name, String password, String address) {
        this.name = name;
        this.password = password;
        this.address = address;
    }
}
