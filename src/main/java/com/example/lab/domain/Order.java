package com.example.lab.domain;

// 주문 결과 — 누가 무엇을 얼마에 샀고 얼마를 할인받았는지
public class Order {
    private final String memberName;
    private final String itemName;
    private final int itemPrice;
    private final int discountPrice;

    public Order(String memberName, String itemName, int itemPrice, int discountPrice) {
        this.memberName = memberName;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountPrice = discountPrice;
    }

    public int getDiscountPrice() { return discountPrice; }

    // 최종 결제 금액
    public int payment() { return itemPrice - discountPrice; }

    @Override
    public String toString() {
        return "Order{member=" + memberName + ", item=" + itemName + ", price=" + itemPrice
                + ", discount=" + discountPrice + ", payment=" + payment() + "}";
    }
}
