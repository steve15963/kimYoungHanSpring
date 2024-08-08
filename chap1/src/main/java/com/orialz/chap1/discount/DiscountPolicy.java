package com.orialz.chap1.discount;

import com.orialz.chap1.member.Member;

public interface DiscountPolicy {
    /**
     * 할인 정책 인터페이스
     * @param member
     * @param price
     * @return 할인된 금액
     */
    int discount(Member member,int price);
}
