package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.entity.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {


    //주문 생성하기
    public List<OrderResponseDto> createOrders(List<CreateOrderRequestDto> createOrderRequestDtos) {
        return createOrderRequestDtos.stream() //리스트의 각 요소를 하나씩 처리할 수 있게 스트림으로 변환
                .map(this::createOrder) //변환된 스트림에 대해 createOrder 메서드를 적용하고, 그 결과로 새로운 스트림 반환
                .peek(orderResponseDto -> log.info("주문이 생성되었습니다. 상품명: {}, 수량: {}, 가격: {}", //스트림의 각 요소를 처리 할때마다 생성된 주문에 대해 로그 출력
                        orderResponseDto.getName(), orderResponseDto.getQuantity(), orderResponseDto.getPrice())) //map() 메소드와 peek() 메소드는 받은 List의 요소 수 만큼 반복
                .collect(Collectors.toList()); //마지막으로, map()메소드로 반환된 스트림을 리스트로 변환하여 반환
    }
    private OrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order createOrder = Order.builder()
                .name(createOrderRequestDto.getName())
                .quantity(createOrderRequestDto.getQuantity())
                .price(createOrderRequestDto.getPrice())
                .build();

        return OrderResponseDto.from(createOrder);
    }

    //주문 가져오기
    public OrderResponseDto getOrder(Long id) {

        Order getOrder = Order.builder()
                .id(id)
                .name("더미 주문")
                .quantity(1)
                .price(100)
                .build();

        return OrderResponseDto.from(getOrder);
    }

    //주문 수정하기
    public OrderResponseDto updateOrder(Long id, UpdateOrderRequestDto updateOrderRequestDto) {

        Order updateOrder = Order.builder()
                .id(id)
                .name(updateOrderRequestDto.getName())
                .quantity(updateOrderRequestDto.getQuantity())
                .price(updateOrderRequestDto.getPrice())
                .build();

        return OrderResponseDto.from(updateOrder);
    }

    //주문 삭제하기
    public void deleteOrder(Long id) {

        log.info("주문이 삭제되었습니다. ID : {}", id);
    }
}
