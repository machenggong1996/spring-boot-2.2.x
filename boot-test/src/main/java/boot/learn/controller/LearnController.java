package boot.learn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author machenggong
 * @date 2020/12/02
 */
@RestController
@RequestMapping("learn")
public class LearnController {

    @GetMapping("get")
    public String get(){
        return "hello";
    }

}
