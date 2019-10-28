package com.test.websockettest.controller;

import com.test.websockettest.server.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangli
 * 2019/10/28  13:38
 */
@RestController
@RequestMapping("/api/ws")
public class WebSocketController {
    /**
     * 群发消息内容
     */
    @GetMapping(value = "/sendAll")
    public String sendAllMessage(@RequestParam(required = true) String message){
        // http 请求的群发信息
        try {
            WebSocketServer.BroadCastInfo(message);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "ok";
    }
    /**
     * 指定会话ID发消息
     * @param message 消息内容
     * @param id 连接会话ID
     * @return
     */
    @GetMapping(value="/sendOne")
    public String sendOneMessage(@RequestParam(required=true) String message,@RequestParam(required=true) String id){
        try {
            WebSocketServer.SendMessage(message,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
