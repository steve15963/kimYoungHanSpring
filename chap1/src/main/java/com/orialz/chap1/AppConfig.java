package com.orialz.chap1;

import com.orialz.chap1.discount.RateDiscountPolicy;
import com.orialz.chap1.member.MemberService;
import com.orialz.chap1.member.MemberServiceImpl;
import com.orialz.chap1.member.MemoryMemberRepository;
import com.orialz.chap1.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderServiceImpl orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }



}
