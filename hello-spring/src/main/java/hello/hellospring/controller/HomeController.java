package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    //static 파일보다 스프링 컨테이너에 있는 컨트롤러가 우선순위가 높다.
    @GetMapping("/")
    public String home(){
        return "home";
    }

}
