package jiwon.todo.repository;

import jakarta.persistence.EntityManager;
import jiwon.todo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findById(Long id){
        return em.find(Member.class, id);
    }

    public boolean existsByLoginId(String loginId){
        Long count = em.createQuery("select count(m) from Member m where m.loginId = :loginId", Long.class)
                .setParameter("loginId", loginId)
                .getSingleResult();
        return count > 0;
    }

    public boolean existsByEmail(String email){
        Long count = em.createQuery("select count(m) from Member m where m.email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }

    public Member findByLoginId(String loginId) {
        Member findMember = em.createQuery("select m from Member m where m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId)
                .getSingleResult();
        return findMember;
    }
}
