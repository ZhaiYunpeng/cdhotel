package com.cdhotel.websocket;

import org.springframework.stereotype.Component;

import com.cdhotel.common.DateUtils;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * @Date: 2019/3/11 13:04
 * @Description:
 */
@Component
@ServerEndpoint("/websocket/{userNo}")
public class WebSocketTest {

    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static int onlineCount = 0;
    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     * 若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
     */
    private static ConcurrentHashMap<String, WebSocketTest> webSocketSet = new ConcurrentHashMap<>();

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session WebSocketsession;
    /**
     * 当前发消息的人员编号
     */
    private String userno = "";

    /**
     * 连接建立成功调用的方法
     *
     * @param WebSocketsession 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam(value = "userNo") String param, Session WebSocketsession, EndpointConfig config) {
        userno = param;//接收到发送消息的人员编号
        this.WebSocketsession = WebSocketsession;
        webSocketSet.put(param, this);//加入map中
        // 在线数加1
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        if (!"".equals(userno)) {
            //从set中删除
            webSocketSet.remove(userno);
            subOnlineCount();           //在线数减1
            System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
//    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        //群发消息
        if (1 < 2) {
            sendAll(message);
        } else {
            //给指定的人发消息
            sendToUser(message);
        }
    }

    /**
     * 给指定的人发送消息
     * @param message
     */
    @OnMessage
    public void sendToUser(String message) {
        String sendUserno = message.split("[|]")[1];
        String sendMessage = message.split("[|]")[0];
        String now = DateUtils.getCurrentDateStr();
        try {
            if (webSocketSet.get(sendUserno) != null) {
                webSocketSet.get(sendUserno).sendMessage(now + "用户" + userno + "发来消息：" + " <br/> " + sendMessage);
            } else {
                System.out.println("当前用户不在线");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 给所有人发消息      * @param message
     */
    public void sendAll(String message) {
        String now = DateUtils.getCurrentDateStr();
        String sendMessage = message.split("[|]")[0];
        //遍历HashMap
        for (String key : webSocketSet
                .keySet()) {
            try {                 //判断接收用户是否是当前发消息的用户
                if (!userno.equals(key)
                ) {
                    webSocketSet.get(key).sendMessage(now + "用户" + userno + "发来消息：" + " <br/> " +
                            sendMessage);
                    System.out.println("key = " + key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }


    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.WebSocketsession.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketTest.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketTest.onlineCount--;
    }
}
