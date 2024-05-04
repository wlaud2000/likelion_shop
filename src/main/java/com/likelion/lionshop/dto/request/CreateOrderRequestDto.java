package com.likelion.lionshop.dto.request;

import com.likelion.lionshop.entity.Order;
import lombok.*;
import org.aspectj.weaver.ast.Or;

@NoArgsConstructor //매개변수 없는 생성자를 생성해 줍니다.
@Getter //모든 필드의 Getter 메서드를 자동으로 생성해줍니다.
public class CreateOrderRequestDto {

    //상품 이름
    public String name;

    //수량
    public int quantity;

    //가격
    public int price;

    @Builder
    public CreateOrderRequestDto(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    //DTO를 Entity로 변환하는 메서드
    public Order toEntity() {
        return Order.builder()
                .name(name)
                .quantity(quantity)
                .price(price)
                .build();
    }
}
