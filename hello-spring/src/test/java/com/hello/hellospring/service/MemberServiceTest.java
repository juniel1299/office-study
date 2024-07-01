package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MemberServiceTest {

    @Test
    void register(){

        MemberService memberService = new MemberService();

        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);


        //then
        memberService.findMe
        Assertions.assertThat()



    }

    @Test
    void findMembers(){

    }

    @Test
    void findOne(){

    }

}
