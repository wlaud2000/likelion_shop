package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.entity.User;
import com.likelion.lionshop.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "어드민 유저 API", description = "어드민 권한 유저 API입니다.")
@RequestMapping(value = "/admin")
public class AdminController {

    private final AdminService adminService;

    //ADMIN ROLE을 가진 사용자만 접근 가능
    @Operation(method = "GET", summary = "모든 유저 조회", description = "DB에 저장되어있는 모든 유저 정보를 조회합니다. 유저의 ROLE값이 ADMIN이면 사용 가능합니다.")
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {

        // ADMIN 권한이 있는 경우 모든 사용자 정보를 조회
        log.info("[ Admin Controller ] 어드민 권한 확인 완료, 모든 유저 정보 조회 시작");
        List<UserResponseDto> allUsers = adminService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
