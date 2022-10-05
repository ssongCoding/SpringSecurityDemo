package com.example.SpringSecurityDemo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class MemberRepository {

    // DB 대신 사용
    private Map<String, Member> members = new HashMap<>();
    private Random random = new Random();

    public Member save(Member member) {
        member.setId(random.nextInt());
        members.put(member.getEmail(), member);
        return member;
    }

    public Member findByEmail(String username) {
        return members.get(username);
    }
}
