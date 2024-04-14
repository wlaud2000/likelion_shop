package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    //사용자 생성
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        User createUser = User.builder()
                .userId(createUserRequestDto.getUserId())
                .name(createUserRequestDto.getName())
                .address(createUserRequestDto.getAddress())
                .build();

        return UserResponseDto.from(createUser);
    }

    //사용자 조회
    public UserResponseDto getUser(String userId) {
        User getUser = User.builder()
                .userId(userId)
                .name("김지명")
                .address("서울시 구로구")
                .build();

        return UserResponseDto.from(getUser);
    }

    //사용자 수정
    public UserResponseDto updateUser(String userId, UpdateUserRequestDto updateUserRequestDto) {
        User updateUser = User.builder()
                .userId(userId)
                .name(updateUserRequestDto.getName())
                .password(updateUserRequestDto.getPassword())
                .address(updateUserRequestDto.getAddress())
                .build();

        return UserResponseDto.from(updateUser);
    }

    //사용자 삭제
    public void deleteUser(String userID) {

        log.info("사용자가 삭제되었습니다. UserID : {}", userID);
    }
}
