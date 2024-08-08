package com.orialz.chap1;

import com.orialz.chap1.member.Grade;
import com.orialz.chap1.member.Member;
import com.orialz.chap1.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "MemberA", Grade.VIP);

        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("Member: " + member);
        System.out.println("findMember: " + findMember);
    }

}
