package com.orialz.chap1.order;

import com.orialz.chap1.discount.DiscountPolicy;
//import com.orialz.chap1.discount.FixDiscountPolicy;
//import com.orialz.chap1.discount.RateDiscountPolicy;
import com.orialz.chap1.member.Member;
import com.orialz.chap1.member.MemberRepository;
import com.orialz.chap1.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class OrderServiceImpl implements OrderService{

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice, discountPrice);
    }
}
