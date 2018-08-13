package com.example.demo.Controller;

import com.example.demo.Mapper.UserMapper;
import com.example.demo.Service.UserService;
import com.example.demo.Service.commen.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/main")
public class HelloController {
    @Resource(name="userService")
    private UserService userService;
    @Autowired
    private ValueOperations valueOperations;
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String sayHello(){
        valueOperations.increment("count",1);
        return  "Hello World!"+valueOperations.get("count");
    }

    @RequestMapping("/testRest")
    public String testRest(){
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("https://mini.eastday.com/json/index/indexMergeNews.json?callback=indexMergeNews&_=1534171368541",String.class);
        String reutrnStr =  restTemplate.getForObject("https://mini.eastday.com/json/index/indexMergeNews.json?callback=indexMergeNews&_=1534171368541",String.class);
        return reutrnStr;
    }

    @RequestMapping("/getUser")
    public List<HashMap> getUser() throws Exception {
        return  userService.getUser();
    }
}
