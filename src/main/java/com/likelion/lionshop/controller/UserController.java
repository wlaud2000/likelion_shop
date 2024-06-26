package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    @PostMapping(value = "/create")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        UserResponseDto userResponseDto = userService.createUser(createUserRequestDto);
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED); //생성 성공시 Status Code 변경
    }

    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping(value = "")
    public ResponseEntity<?> getUser(@AuthenticationPrincipal UserDetails userDetails) {
        UserResponseDto userResponseDto = userService.getUser(userDetails.getUsername());
        return new ResponseEntity<>(userResponseDto,HttpStatus.OK);
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    //UpdateUserRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping(value = "")
    public String updateUser(@AuthenticationPrincipal UserDetails userDetails,
                             @RequestBody UpdateUserRequestDto updateUserRequestDto) {
        userService.updateUser(userDetails.getUsername(), updateUserRequestDto);
        return "사용자 수정";
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping(value = "")
    public String deleteUser(@AuthenticationPrincipal UserDetails userDetails) {
        userService.deleteUser(userDetails.getUsername());
        return "사용자 삭제";
    }

}
