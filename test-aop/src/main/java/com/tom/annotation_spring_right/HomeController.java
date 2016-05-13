package com.tom.annotation_spring_right;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom on 2016/5/3.
 */
@Controller
public class HomeController {
    /*主页不需要权限*/
    @RequestMapping(value={"","/"}, method= RequestMethod.GET)
    public ModelAndView Home() throws Exception {
        //some code
        return new ModelAndView("index");
    }
    //100为数据库对应的角色对某个资源的拥有情况
    @FireAuthority(accessRightId= 100,resultType =ResultTypeEnum.page )
    @RequestMapping(value="/user", method= RequestMethod.GET)
    public ModelAndView user(String  name) throws Exception {
        //some code
        return new ModelAndView("index");
    }
    @FireAuthority(accessRightId= 100,resultType =ResultTypeEnum.json )
    @RequestMapping(value="/user2", method= RequestMethod.GET)
    public ModelAndView user2(String  name) throws Exception {
        //some code
        return new ModelAndView("index");
    }
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)  {
        //假设该角色拥有这些权限
        WebUtils.setSessionAttribute(request,"ACCESS_RIGHTS",new Integer[]{100,150,180});
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response)  {
        //假设该角色去掉这些权限
        WebUtils.setSessionAttribute(request,"ACCESS_RIGHTS",null);
        return "index";
    }

    @RequestMapping("/error")
    public ModelAndView error(@RequestParam boolean oprst,@RequestParam String opmsg) throws Exception {
        //some code
        Map map=new HashMap<>();
        map.put("oprst",oprst);
        map.put("opmsg",opmsg);
        return new ModelAndView("error",map);
    }



}
