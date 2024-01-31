package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("Yongmin Kim");

        //when
        Long saveID = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveID).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void checkDuplicatedMember() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
//        try {
//            memberService.join(member2);
//            //성공하면 안되니까 테스트가 실패
//            fail();
//        }catch (RuntimeException e){
//            assertThat(e.getMessage()).isEqualTo("java.lang.IllegalAccessException: 이미 존재하는 회원입니다.");
//        }
        //then
        assertThrows(RuntimeException.class, () -> memberService.join(member2));
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}