package jp.cogel.springboot.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shigeru on 15/09/15.
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method=RequestMethod.GET)
    public String hello() {
        return "Hello Spring MVC";
    }
}
