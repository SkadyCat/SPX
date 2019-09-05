package com.main.activity.loginsystem;

import com.main.activity.chat.Chat;
import com.main.activity.info.XInfo;
import io.swagger.annotations.Info;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginUser {
   public String user_acc;

   public static Map<String, Chat> p2pMap = new HashMap<>();


   /**
    * 通过friendID去查找到是否存在该房间
    * @return
    * 100->成功，说明myID有我的房间，我只需要获得这个房间号就行
    * 200->失败，说明friend没有我的房间，我需要去创建这个房间号
    */
   public XInfo findChatByFrindID(String friendID){
      XInfo info = new XInfo();

      for (String key :
              p2pMap.keySet()) {

         Chat chat = p2pMap.get(key);
         for (String userAcc: chat.userList
              ) {

            if (userAcc.equals(friendID)){
               info.code = 100;
               info.arg1 = chat.chatID;
               return info;

            }
         }

         
      }
      info.code = 200;

      return info;

   }

   public static void storeChatInP2PMap(String chatID,Chat chat){
      if (p2pMap.containsKey(chatID) == false){

         p2pMap.put(chatID,chat);
      }


   }

   public void addMessage(String value){


   }

}
