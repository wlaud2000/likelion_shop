package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {


    //주문 생성하기
    public OrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order createOrder = Order.builder()
                .name(createOrderRequestDto.getName())
                .quantity(createOrderRequestDto.getQuantity())
                .price(createOrderRequestDto.getPrice())
                .build();

        return OrderResponseDto.toDto(createOrder);
    }

    //주문 가져오기
    public OrderResponseDto getOrder(Long id) {

        Order getOrder = Order.builder()
                .id(id)
                .name("더미 주문")
                .quantity(1)
                .price(100)
                .build();

        return OrderResponseDto.toDto(getOrder);
    }

    //주문 수정하기
    public OrderResponseDto updateOrder(Long id, UpdateOrderRequestDto updateOrderRequestDto) {

        Order updateOrder = Order.builder()
                .id(id)
                .name(updateOrderRequestDto.getName())
                .quantity(updateOrderRequestDto.getQuantity())
                .price(updateOrderRequestDto.getPrice())
                .build();

        return OrderResponseDto.toDto(updateOrder);
    }

    //주문 삭제하기
    public void deleteOrder(Long id) {

        log.info("주문이 삭제되었습니다. ID : {}", id);
    }
}
