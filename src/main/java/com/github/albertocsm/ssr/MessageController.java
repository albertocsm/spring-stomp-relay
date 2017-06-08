package com.github.albertocsm.ssr;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api")
public class MessageController {

  private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

  @Autowired
  private SimpMessagingTemplate brokerMessagingTemplate;

  /**
   */
  @RequestMapping(value = "/message", method = RequestMethod.POST)
  public ResponseEntity<Void> broadcast(
      @RequestBody Message message,
      HttpServletRequest request) {

    message.sender(request.getRemoteAddr());

    // Push on websocket
    brokerMessagingTemplate.convertAndSend("/stomp/my-channel", message);

    return ResponseEntity.noContent().build();
  }
}
