package com.main.activity;


import com.main.DB.DataBaseOP;
import com.main.DB.UserInfoDBOP;
import com.main.DynamicLayer.User;
import com.main.Model.UserModel;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

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
