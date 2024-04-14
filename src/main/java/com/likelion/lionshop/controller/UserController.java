package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequiredArgsConstructor
@RequestMapping("/user") // uri가 /user로 시작하는 요청을 받습니다.
public class UserController {

    private final UserService userService;

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    //CreateUserRequestDto 클래스를 매개변수로 받습니다.
    @PostMapping(value = "")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(createUserRequestDto);
        log.info("사용자가 생성되었습니다. ID: {}, 이름: {}, 주소: {}",
                userResponseDto.getUserId(),
                userResponseDto.getName(),
                userResponseDto.getAddress());
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED); //생성 성공시 Status Code 변경
    }

    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable("userId") String userId) {
        UserResponseDto userResponseDto = userService.getUser(userId);
        log.info("사용자가 조회되었습니다. ID: {}, 이름: {}, 주소: {}",
                userResponseDto.getUserId(),
                userResponseDto.getName(),
                userResponseDto.getAddress());
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    //UpdateUserRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping(value = "/{userId}")
    public ResponseEntity<UserResponseDto> updateUser(@PathVariable("userId") String userId,
                                                      @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        UserResponseDto userResponseDto = userService.updateUser(userId, updateUserRequestDto);
        log.info("사용자정보가 수정 되었습니다. 이름: {}, 비밀번호: {}, 주소: {}",
                userResponseDto.getName(),
                userResponseDto.getPassword(),
                userResponseDto.getAddress());
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping(value = "/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {

        userService.deleteUser(userId);
        return "사용자 삭제";
    }

}
