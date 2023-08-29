package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")    // http의 get과 같음 주소의 /hello를 일치시키면 아래 메소드 실행
    public String Hello(Model model){
        model.addAttribute("data", "!!");
        return "hello"; // templates의 hello.html에 담아 실행하도록 명령 + model("hello!!")를 담아서
    }

    @GetMapping("hello-mvc")    // hello-mvc?name=spring으로 접속하여 template으로 넘겨줌
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    @GetMapping("hello-string")     // template을 통해서 화면에 출력되는게 아니라 데이터부분을 그대로 보여주는 형태
    @ResponseBody       // http의 body부분에 직접 데이터를 넣어주어 데이터를 받겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;  //  "hello spring"
    }

    @GetMapping("hello-api")    // 객체를 보내주어 html에서 json 형태로 출력되는 형태
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
