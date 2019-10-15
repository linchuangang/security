package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "demo_sign";
    }


    @RequestMapping(value = "/doLogin", method = RequestMethod.GET)
    @ResponseBody
    public String doLogin(String userName, String password) {
        System.out.println(userName + "===" + password);
        return "success";
    }

    @RequestMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

}
