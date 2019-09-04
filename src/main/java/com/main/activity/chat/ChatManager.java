package com.main.activity.chat;

import com.main.Tool.JqueryRequestTool;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ChatManager {

    public static Map<String,Chat> chatMap = new HashMap<>();


    public static String  createChat(String key){
        Chat chat = new Chat(key);

        chatMap.put(chat.chatID,chat);

        return chat.chatID;
    }




    /**
     * 0->返回失败
     * @param chatUser
     * @param key
     * @return
     */
    public int  chatAddUser(String chatUser,String key){
        if (chatMap.containsKey(chatUser) == true)
        {
            //chatMap.get(chatUser).

            return 100;

        }
        else {

            return 0;
        }



    }



    @GetMapping("/onreceive")
    public String onReceive( HttpServletRequest request){
        JqueryRequestTool tool = new JqueryRequestTool(request);

        System.out.println(tool.jsonObject.toString());

        if (chatMap.containsKey(tool.jsonObject.get("chat_id").toString()) == false){

            ChatManager.createChat(tool.jsonObject.get("chat_id").toString());

        }
        System.out.println(tool.jsonObject.get("chat_id").toString());
        Chat cht = ChatManager.chatMap.get(tool.jsonObject.get("chat_id").toString());

        System.out.println(cht);
        cht.addMessage(tool.jsonObject.get("user_acc").toString(),tool.jsonObject.get("valueInput").toString());

        return cht.getMessage();

    }
}
