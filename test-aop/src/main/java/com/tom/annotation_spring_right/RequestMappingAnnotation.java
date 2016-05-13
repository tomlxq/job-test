package com.tom.annotation_spring_right;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tom on 2016/5/5.
 *
 * 69.@RequestMapping annotation
 @RequestMapping注解用于将URL映射到任何一个类或者一个特定的处理方法上。
 */
@Controller
@RequestMapping("/requestMappingAnnotation")
public class RequestMappingAnnotation {
    @RequestMapping("test")
    public @ResponseBody String test(){
        return "hello";
    }
}
