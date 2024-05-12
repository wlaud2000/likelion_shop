package com.likelion.lionshop.dto.request;

import com.likelion.lionshop.entity.User;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@NoArgsConstructor //매개변수 없는 생성자를 생성해 줍니다.
@Getter //모든 필드의 Getter 메서드를 자동으로 생성해줍니다.
public class CreateUserRequestDto {

    public String name;

    public String email;

    public String password;

    public String address;

    @Builder
    public CreateUserRequestDto(String name, String email, String password, String address) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    //User Dto -> User Entity로 변환하는 메서드
    public User toEntity(PasswordEncoder passwordEncoder) {
        //Password Encoder 통해 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(password);
        return User.builder()
                .name(name)
                .email(email)
                .password(encodedPassword) //암호화된 비밀번호 저장
                .address(address)
                .roles("USER")
                .build();
    }
}
