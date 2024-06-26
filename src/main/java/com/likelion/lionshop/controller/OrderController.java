package com.likelion.lionshop.controller;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j //로그 출력을 도와주는 어노테이션
@RestController
@RequiredArgsConstructor
@RequestMapping("/order") // uri가 /oroder로 시작하는 요청을 받습니다.
public class OrderController {

    private final OrderService orderService;

    // 1. 주문을 생성하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 생성하기"입니다. -> 주문은 리스트 형태로 요청을 보내주세요!
    @PostMapping(value = "")
    public ResponseEntity<List<OrderResponseDto>> createOrders(@RequestBody List<CreateOrderRequestDto> createOrderRequestDtos,
                                                               @AuthenticationPrincipal UserDetails userDetails) { //List형태로 주문을 받을 수 있게 수정

        List<OrderResponseDto> orderResponseDtos = orderService.createOrders(createOrderRequestDtos);
        return new ResponseEntity<>(orderResponseDtos, HttpStatus.CREATED);
    }


    // 2. 주문을 가져오는 컨트롤러를 만듭니다. 이때 return 값은 "주문 가져오기"입니다.
    @GetMapping(value = "/{orderId}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable("orderId") Long id,
                                                     @AuthenticationPrincipal UserDetails userDetails) {

        OrderResponseDto orderResponseDto = orderService.getOrder(id);
        return new ResponseEntity<>(orderResponseDto,HttpStatus.OK);
    }

    // 3. 주문을 수정하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 수정하기"입니다.
    //UpdateOrderRequestDto 클래스를 매개변수로 받습니다.
    @PutMapping("/{orderId}")
    public ResponseEntity<String> updateOrder(@PathVariable("orderId") Long id,
                                              @RequestBody UpdateOrderRequestDto updateOrderRequestDto,
                                              @AuthenticationPrincipal UserDetails userDetails) {
        orderService.updateOrder(id, updateOrderRequestDto);
        return new ResponseEntity<>("주문 수정", HttpStatus.OK);
    }

    // 4. 주문을 삭제하는 컨트롤러를 만듭니다. 이때 return 값은 "주문 삭제하기"입니다.
    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Long id,
                                              @AuthenticationPrincipal UserDetails userDetails) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>("주문 삭제하기", HttpStatus.OK);
    }
}
