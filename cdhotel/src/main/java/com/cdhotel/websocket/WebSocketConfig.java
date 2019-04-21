package com.cdhotel.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Auther: Administrator
 * @Date: 2019/3/11 14:00
 * @Description:
 */
@Configuration
@ComponentScan("com.cdhotel.websocket")
public class WebSocketConfig {
        @Bean
        public ServerEndpointExporter serverEndpointExporter() {
            return new ServerEndpointExporter();
    }
}
