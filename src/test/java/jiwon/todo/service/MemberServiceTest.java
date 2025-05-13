package jiwon.todo.service;

import jiwon.todo.domain.Member;
import jiwon.todo.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberRepository memberRepository;
    @Autowired MemberService memberService;

    @Test
    public void 회원가입() {
        // given
        Member member = new Member(100000L, "loginId", "password", "userName", "todo123@naver.com");

        // when
        Long joinedId = memberService.join(member);

        // then
        Assertions.assertEquals(member, memberRepository.findById(joinedId));
    }

}