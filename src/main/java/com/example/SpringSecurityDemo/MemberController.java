package com.example.SpringSecurityDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    private MemberService memberService;

    /**
     * 의존성 주입 방법 : 생성자 이용
     * - 생성자가 1개만 있을 때
     * - 매개변수가 모두 빈으로 등록되어 있을 때만
     * @param memberService
     */
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/create") // 원래 post가 맞습니다.
    public Member create() {
        // 간단하게 보여드리려고, 사용자한테 받은 척
        Member member = new Member();
        member.setEmail("songa@hyundai.com");
        member.setPassword("songa");

        return memberService.save(member);
    }
}
