package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateUserRequestDto;
import com.likelion.lionshop.dto.request.UpdateUserRequestDto;
import com.likelion.lionshop.dto.response.UserResponseDto;
import com.likelion.lionshop.entity.User;
import com.likelion.lionshop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepository userRepository;

    //사용자 생성
    public UserResponseDto createUser(CreateUserRequestDto createUserRequestDto) {
        //파라미터로 받은 DTO를 Entity로 변환
        User user = createUserRequestDto.toEntity();
        //변환한 Entity를 DB에 저장
        userRepository.save(user);

        log.info("[ User Service ] 사용자가 생성되었습니다.");
        log.info("[ User Service ] 이름 ---> {}", user.getName());
        log.info("[ User Service ] 주소 ---> {}", user.getAddress());
        log.info("[ User Service ] 아이디 ---> {}", user.getUserId());
        log.info("[ User Service ] 비밀번호 ---> {}", user.getPassword());

        //DB에 저장한 Entity를 DTO로 변환 후 반환
        return UserResponseDto.from(user);
    }

    //사용자 조회
    @Transactional(readOnly = true) //읽기 전용
    public UserResponseDto getUser(Long id) {
        //id로 User 조회
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("사용자를 찾을 수 없습니다. ID: " + id));

        log.info("[ User Service ] 사용자정보를 가져왔습니다.");
        log.info("[ User Service ] ID ---> {}", user.getUserId());
        log.info("[ User Service ] 이름 ---> {}", user.getName());
        log.info("[ User Service ] 주소 ---> {}", user.getAddress());

        //조회 한 user Entity를 DTO로 변환 후 반환
        return UserResponseDto.from(user);
    }

    //사용자 수정
    public void updateUser(Long id, UpdateUserRequestDto updateUserRequestDto) {
        //id로 User 조회
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("사용자를 찾을 수 없습니다. ID: " + id));
        //파라미터로 받은 DTO로 user 업데이트
        user.update(updateUserRequestDto);
        //업데이트 한 user를 DB에 저장
        userRepository.save(user);

        log.info("[ User Service ] 아룸이 수정되었습니다 ---> {}", user.getName());
        log.info("[ User Service ] 주소가 수정되었습니다 ---> {}", user.getAddress());
        log.info("[ User Service ] 비밀번호가 수정되었습니다 ---> {}", user.getPassword());
    }

    //사용자 삭제
    public void deleteUser(Long id) {
        //id로 User 조회
        User user = userRepository.findById(id).orElseThrow(() ->
                new RuntimeException("사용자를 찾을 수 없습니다. ID: " + id));
        //DB에서 조회 한 user 삭제
        userRepository.delete(user);

        log.info("[ User Service ] 사용자가 삭제되었습니다. UserID ---> {}", user.getUserId());
    }
}
