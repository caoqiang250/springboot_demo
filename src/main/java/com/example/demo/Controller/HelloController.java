package com.example.demo.Controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/main")
public class HelloController {
    @Resource(name="userService")
    private UserService userService;

    @RequestMapping("/hello")
    public String sayHello(){
        return  "Hello World!";
    }

    @RequestMapping("/getUser")
    public List<HashMap> getUser() throws Exception {
        return  userService.getUser();
    }
}
