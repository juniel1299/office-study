package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;



    // 들어온 데이터 값 저장 (sequence ++을 통해 자동으로 시퀀스 숫자 상승)
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }


    // null 값도 가능하도록 설정
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }



    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }


    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    public void clearStore() {
        store.clear();
    }

}
