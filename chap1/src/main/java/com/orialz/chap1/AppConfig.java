package com.orialz.chap1;

import com.orialz.chap1.discount.RateDiscountPolicy;
import com.orialz.chap1.member.MemberRepository;
import com.orialz.chap1.member.MemberService;
import com.orialz.chap1.member.MemberServiceImpl;
import com.orialz.chap1.member.MemoryMemberRepository;
import com.orialz.chap1.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderServiceImpl orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }

    @Bean
    public RateDiscountPolicy rateDiscountPolicy(){
        return new RateDiscountPolicy();
    }

}
