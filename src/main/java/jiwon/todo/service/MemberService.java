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

    public Member login(String loginId, String password){
        Member findMember = memberRepository.findByLoginId(loginId);

        // loginId가 존재하지 않는 경우 예외
        if(findMember == null){
            throw new IllegalArgumentException("loginId is not exist");
        }

        // 비밀번호가 일치하지 않는 경우 예외
        if(!findMember.getPassword().equals(password)){
            throw new IllegalArgumentException("wrong password");
        }

        // 입력한 비밀번호와 저장된 비밀번호가 일치하면 회원을 반환
        return findMember;
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
