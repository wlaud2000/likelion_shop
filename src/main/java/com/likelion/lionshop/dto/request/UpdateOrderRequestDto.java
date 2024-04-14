package com.likelion.lionshop.dto.request;

import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED) //매개변수 없는 생성자를 생성해 줍니다.
@Getter //모든 필드의 Getter 메서드를 자동으로 생성해줍니다.
public class UpdateOrderRequestDto {
    //상품의 ID
    public Long id;

    //상품 이름
    public String name;

    //수량
    public int quantity;

    //가격
    public int price;

    @Builder
    public UpdateOrderRequestDto(Long id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

}
