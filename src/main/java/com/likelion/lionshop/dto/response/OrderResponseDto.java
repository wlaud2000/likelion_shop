package com.likelion.lionshop.dto.response;

import com.likelion.lionshop.entity.Order;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderResponseDto {

    private Long id;
    private String name;
    private int quantity;
    private int price;

    @Builder
    public OrderResponseDto(Long id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public static OrderResponseDto from(Order order) { // Entity -> DTO로 변환 정적 메소드 사용으로 객체 생성을 위해 별도의 인스턴스를 생성할 필요가 없음, toDto에서 from으로 메소드 이름 변경
        return OrderResponseDto.builder()
                .id(order.getId())
                .name(order.getName())
                .quantity(order.getQuantity())
                .price(order.getPrice())
                .build();
    }


}


