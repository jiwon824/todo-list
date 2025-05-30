package jiwon.todo.service;

import jiwon.todo.domain.Member;
import jiwon.todo.domain.Todo;
import jiwon.todo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // 회원가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        if (memberRepository.existsByLoginId(member.getLoginId())) {
            throw new IllegalStateException("loginId is already used");
        }

        if (memberRepository.existsByEmail(member.getEmail())) {
            throw new IllegalStateException("email is already registered.");
        }
    }

    public Member findById(Long id){
        return memberRepository.findById(id);
    }

}
