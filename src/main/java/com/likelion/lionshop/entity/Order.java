package com.likelion.lionshop.entity;

import com.likelion.lionshop.dto.request.UpdateOrderRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 생성자를 통해서 값 변경 목적으로 접근하는 메시지들 차단 (다른 패키지에 소속된 클래스는 접근 제한)
public class Order {

    @Id //PK 설정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본 키 생성 DB에 위임하는 전략
    private Long id;

    @Column
    private String name;

    @Column
    private int quantity;

    @Column
    private int price;

    @ManyToOne(fetch = FetchType.LAZY) //지연로딩 설정
    private User user;

    @Builder
    protected Order(Long id, String name, int quantity, int price, User user) { //캡슐화 유지. protected로 외부 클래스에서 직접 인스턴스화할 수 없개 작성
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.user = user;
    }

    public void update(UpdateOrderRequestDto updateOrderRequestDto) {
        name = updateOrderRequestDto.getName();
        quantity = updateOrderRequestDto.getQuantity();
        price = updateOrderRequestDto.getPrice();
    }
}
