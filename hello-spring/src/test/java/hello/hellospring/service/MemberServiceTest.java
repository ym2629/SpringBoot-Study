package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

//    MemberService memberService = new MemberService();
//    //이해가 안되는게 MemberService에서 따로 MemoryMemberRepository객체를 생성해서 사용하는데
//    //왜 다른 객체에서 clearStore()을 하는데 MemberService의 MemoryMemberRepository의 내용이 삭제되지?
//    //Map이 static으로 선언되어 있어서 문제가 안되는거라는데? -> 근데 좀 껄끄러운 거라고 말하심 -> static이면 같은 db가 되나봐
//    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }
    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

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