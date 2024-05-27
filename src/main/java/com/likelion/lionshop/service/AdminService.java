package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.entity.User;
import com.likelion.lionshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;

      // 모든 사용자 정보 조회하기
    @Transactional(readOnly = true) // 읽기 전용
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll(); // 모든 사용자 조회

        List<UserResponseDto> userResponseDtos = users.stream()
                .map(UserResponseDto::from)
                .collect(Collectors.toList());

        userResponseDtos.forEach(userResponseDto -> {
            log.info("[ User Service ] 사용자정보를 가져왔습니다.");
            log.info("[ User Service ] ID ---> {}", userResponseDto.getEmail());
            log.info("[ User Service ] 이름 ---> {}", userResponseDto.getName());
            log.info("[ User Service ] 주소 ---> {}", userResponseDto.getAddress());
            log.info("----------------------------------------------------");
        });

        return userResponseDtos;
    }

}
