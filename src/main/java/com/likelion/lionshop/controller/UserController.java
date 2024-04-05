package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.CreateUserRequestDto;
import com.likelion.lionshop.dto.UpdateUserRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/user") // uri가 /user로 시작하는 요청을 받습니다.
public class UserController {

    // 1. 사용자를 생성하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 이름, 주소, ID, PW를 출력해줍니다. return 값은 "사용자 생성"입니다.
    //CreateUserRequestDto 클래스를 매개변수로 받습니다.
    @PostMapping(value = "")
    public String createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {

        log.info("name = {}",createUserRequestDto.getName());
        log.info("address = {}", createUserRequestDto.getAddress());
        log.info("ID = {}", createUserRequestDto.getId());
        log.info("PW = {}", createUserRequestDto.getPassword());
        return "사용자 생성";
    }

    // 2. 사용자를 조회하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 조회"입니다.
    @GetMapping(value = "/{userId}")
    public String getUser(@PathVariable("userId") String userId) {

        log.info("ID = {}",userId);
        return "사용자 조회";
    }

    // 3. 사용자를 수정하는 컨트롤러를 만듭니다.
    // 이때 log.info를 이용를여 사용자의 이름, 주소를 출력해줍니다. return 값은 "사용자 수정"입니다.
    //UpdateUserRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping(value = "/{userId}")
    public String updateUser(@PathVariable("userId") String userId,
                             @RequestBody UpdateUserRequestDto updateUserRequestDto) {

        log.info("name = {}", updateUserRequestDto.getName());
        log.info("address = {}", updateUserRequestDto.getAddress());
        return "사용자 수정";
    }

    // 4. 사용자를 삭제하는 컨트롤러를 만듭니다.
    // 이때 log.info 이용하여 사용자의 ID를 출력해줍니다. return 값은 "사용자 삭제"입니다.
    @DeleteMapping(value = "/{userId}")
    public String deleteUser(@PathVariable("userId") String userId) {

        log.info("사용자 삭제");
        return "사용자 삭제";
    }

}
