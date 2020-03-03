package cn.mo.myclient1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * desc:
 *
 * @author mozhihang
 * date:2020/3/3 11:42
 */
//@RequestMapping("/index")
@RestController
public class IndexController {

    @GetMapping("/hello")
    public String hello(){
        return "hello, world!";
    }

    @GetMapping("/")
    public String index(){
        return "index!";
    }

    @GetMapping("/index/my-client-1/a")
    public String test(){
        return "/index/my-client-1/a";
    }

}
