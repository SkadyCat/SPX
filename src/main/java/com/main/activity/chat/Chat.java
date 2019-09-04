package com.main.activity.chat;

import java.util.*;

public class Chat {

    Map<String,String> chatMap = new HashMap<>();
    public  Chat(String key){


        this.chatID = key;

    }

    public void  addUser(String user_acc){

        chatMap.put(user_acc,user_acc);

    }
    public String chatID;
    public List<String> chatMessageList = new ArrayList<>();

    public String getMessage(){

        String key = "";

        for (String ke:chatMessageList
             ) {

            key += ke+"&";

        }
        return  key;
    }

    public String addMessage(String user_acc,String message){
        //从数据库里面读取用户名

        chatMessageList.add(user_acc+":"+message);


        return "";

    }

}
