package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.response.JwtDto;
import com.likelion.lionshop.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    //토큰 재발급 API
    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(@RequestBody JwtDto jwtDto) {

        log.info("[ Auth Controller ] 토큰을 재발급합니다. ");

        return ResponseEntity.ok(authService.reissueToken(jwtDto));
    }
}
