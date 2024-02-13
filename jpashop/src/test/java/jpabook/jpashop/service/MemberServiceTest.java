package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import jpabook.jpashop.MemberRepository;
import junit.framework.TestCase;
import org.junit.runner.RunWith;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest extends TestCase {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Test
    public void testJoin() {
        //Given
        Member member = new Member();
        member.setName("kim");
        //When
        Long saveId = memberService.join(member);
        //Then
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void testFindMembers() {
        //Given
        Member member1 = new Member();
        member1.setName("kim");
        Member member2 = new Member();
        member2.setName("kim");
        //When
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다.
        //Then
        fail("예외가 발생해야 한다.");
    }
}