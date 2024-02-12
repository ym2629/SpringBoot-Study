package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //스프링이 자동으로 생성해줌. 스프링 빈으로 등록. �
public class MemberRepository {
    // 스프링 컨테이너에서 엔티티 매니저 주입
    @PersistenceContext
    EntityManager em;
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }
    public Member find(Long id){
        return em.find(Member.class, id);
    }
}
