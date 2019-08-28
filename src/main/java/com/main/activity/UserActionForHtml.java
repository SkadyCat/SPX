package com.main.activity;


import com.main.DynamicLayer.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserActionForHtml {

    public static String randomValue = "456123";



    @GetMapping("/login")
    public String login(String skey){


        if (User.vorify(skey) == true)
        {
            System.out.println("已经登陆，刷新页面！");
            return "hall/homepage.html";
        }

        if(skey.equals(randomValue))
        {

            System.out.println("进入新的页面！");
            String a = "";

            return "hall/homepage.html";
        }else {

            return "login/login_page.html";

        }




    }





}
