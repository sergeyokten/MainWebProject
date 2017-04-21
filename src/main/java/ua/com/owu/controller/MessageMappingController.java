package ua.com.owu.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import ua.com.owu.entity.chat.Message;
import ua.com.owu.entity.chat.OutputMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller //test
public class MessageMappingController {
    @MessageMapping("/chat") // от кого принимать
    @SendTo("/topic/messages") // куда отправлять ответ OutputMessage
    public OutputMessage send(Message message) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
