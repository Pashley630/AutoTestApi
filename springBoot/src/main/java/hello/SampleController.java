package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }


    //执行此方法成功后，浏览器输入localhost:9090 端口默认是8080， application.properties配置为9090
    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
