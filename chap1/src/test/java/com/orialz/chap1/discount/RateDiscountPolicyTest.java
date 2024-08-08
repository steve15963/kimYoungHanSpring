package com.orialz.chap1.discount;

import com.orialz.chap1.member.Grade;
import com.orialz.chap1.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        Member member = new Member(1L, "VIP", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인되면 안된다.")
    void vip_x() {
        Member member = new Member(2L, "VIP", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }
}