package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

@Autowired
public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
}
    //회원가입
    public Long join(Member member) {

        //같은 이름이 있는 중복 회원 X

//        Optional<Member> result = memberRepository.findByName(member.getName());
//        Member member1 = result.get();

        validateDuplicateMember(member); //중복 회원 검증


        memberRepository.save(member);
        return member.getId();


    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
            //에러 문구
                try {
                    throw new IllegalAccessException("이미존재하는 회원입니다.");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            });
    }


    //전체 회원 조회 기능
    public List<Member> findMembers(){

        return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberid){

        return memberRepository.findById(memberid);
    }



}
