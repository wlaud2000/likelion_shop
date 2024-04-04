package com.likelion.lionshop.controller;

import ch.qos.logback.core.model.Model;
import com.likelion.lionshop.dto.CreateOrderRequestDto;
import com.likelion.lionshop.dto.UpdateOrderRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequestMapping("/order") // uri가 /oroder로 시작하는 요청을 받습니다.
public class OrderController {

    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    //CreateOrderRequestDto 클래스를 매개변수로 받습니다.
    @PostMapping(value = "")
    public String createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto){
        log.info("주문 생성하기");
        log.info("name = {}", createOrderRequestDto.getName());
        return "주문 생성하기";
    }


    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @GetMapping(value = "")
    public String getOrder() {
        log.info("주문 가져오기");
        return "주문 가져오기";
    }

    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    //UpdateOrderRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping(value = "")
    public String updateOrder(@RequestBody UpdateOrderRequestDto updateOrderRequestDto) {
        log.info("주문 수정하기");
        log.info("quantity = {}", updateOrderRequestDto.getQuantity());
        return "주문 수정하기";
    }

    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @DeleteMapping(value = "")
    public String deleteOrder() {
        log.info("주문 삭제하기");
        return "주문 삭제하기";
    }

}
