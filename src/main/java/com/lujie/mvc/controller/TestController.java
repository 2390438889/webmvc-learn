package com.lujie.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Hearts
 * @date 2019/5/13
 * @desc
 */
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }


}
