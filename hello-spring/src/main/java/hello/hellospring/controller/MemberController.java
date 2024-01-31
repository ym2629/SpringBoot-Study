package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //    //이러면 별 기능이 없는데 여러 컨테이너가 MemberService 객체를 다 선언해서 쓰게 된다
    //    //스프링 컨테이너에 등록하면 한번만 선언하면 됨
    //    private final MemberService memberService = new MemberService();
    private final MemberService memberService;

    //@Autowired -> MemberService 를 스프링 컨테이너에서 가져옴 -> 의존성 주입이라고 함
    //오류가 나옴 -> 스프링이 MemberService을 알 방법이 없음(순수 자바 코드여서)
    // MemberService 에 @Service 를 추가해주면 됨, Repository 도 MemberService 에서 쓰기 때문에 @Repository 를 써줘야 됨

    //스프링 빈을 등록하는 방법 2가지 -> 기본적으로 싱글톤 등록(유일하게 하나만 등록함)
    //@Component -> @Component 를 포함하는 @Controller, @Server, @Repository 도 자동으로 등록됨
    //1. 컴포넌트 스캔과 자동 의종관계 설정
    //2. 자바코드로 직접 스프링 빈 등록하기

    //속도가 빨라지겠네
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}