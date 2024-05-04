package com.likelion.lionshop.service;

import com.likelion.lionshop.dto.request.CreateOrderRequestDto;
import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import com.likelion.lionshop.dto.response.OrderResponseDto;
import com.likelion.lionshop.entity.Order;
import com.likelion.lionshop.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    //주문 생성하기
    public List<OrderResponseDto> createOrders(List<CreateOrderRequestDto> createOrderRequestDtos) {
        return createOrderRequestDtos.stream() //리스트의 각 요소를 하나씩 처리할 수 있게 스트림으로 변환
                .map(this::createOrder) //변환된 스트림에 대해 createOrder 메서드를 적용하고, 그 결과로 새로운 스트림 반환
                .peek(orderResponseDto -> {
                        log.info("[ Order Service ] 주문이 완료되었습니다.");
                        log.info("[ Order Service ] 이름 ---> {}", orderResponseDto.getName());
                        log.info("[ Order Service ] 수량 ---> {}", orderResponseDto.getQuantity());
                        log.info("[ Order Service ] 가격 ---> {}", orderResponseDto.getPrice());
                    }) //map() 메소드와 peek() 메소드는 받은 List의 요소 수 만큼 반복
                .collect(Collectors.toList()); //마지막으로, map()메소드로 반환된 스트림을 리스트로 변환하여 반환
    }
    private OrderResponseDto createOrder(CreateOrderRequestDto createOrderRequestDto) {
        Order order = createOrderRequestDto.toEntity(); // DTO를 엔터티로 변환
        orderRepository.save(order); // DB에 저장
        return OrderResponseDto.from(order); // 엔터티를 OrderResponseDto로 변환
    }


    //주문 가져오기
    @Transactional(readOnly = true) //읽기 전용
    public OrderResponseDto getOrder(Long id) {
        // ID로 주문을 조회
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("주문을 찾을 수 없습니다. ID: " + id));

        log.info("[ Order Service ] 주문 정보를 가져왔습니다.");
        log.info("[ Order Service ] 주문 가져오기 ID ---> {}", id);
        log.info("[ Order Service ] 이름 ---> {}", order.getName());
        log.info("[ Order Service ] 가격 ---> {}", order.getPrice());
        log.info("[ Order Service ] 수량 ---> {}", order.getQuantity());

        //조회한 order Entity를 DTO로 변환해서 반환
        return OrderResponseDto.from(order);
    }

    //주문 수정하기
    public void updateOrder(Long id, UpdateOrderRequestDto updateOrderRequestDto) {

        //DB에서 가져오는 로직
        Order order = orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("주문을 찾을 수 없습니다. ID: " + id));

        //수정하는 로직
        order.update(updateOrderRequestDto);

        //수정 후 DB에 저장하는 로직
        orderRepository.save(order);

        log.info("[ Order Service ] 주문이 수정되었습니다. ID ---> {}", id);
        log.info("[ Order Service ] 주문이 수정되었습니다. 이름 ---> {}", order.getName());
        log.info("[ Order Service ] 주문이 수정되었습니다. 가격 ---> {}", order.getPrice());
        log.info("[ Order Service ] 주문이 수정되었습니다. 수량 ---> {}", order.getQuantity());

    }

    //주문 삭제하기
    public void deleteOrder(Long id) {

//        // ID로 주문을 조회
//        Order order = orderRepository.findById(id).orElseThrow(() ->
//                new RuntimeException("주문을 찾을 수 없습니다. ID: " + id));

        //주문을 삭제
        orderRepository.deleteById(id);
        log.info("[ Order Service ] 주문이 삭제되었습니다. ID ---> {}", id);
    }
}
