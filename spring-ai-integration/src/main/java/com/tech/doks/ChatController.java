package com.tech.doks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private ChatClient chatClient;
    private static final Logger log = LoggerFactory.getLogger(ChatController.class);

    public ChatController(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(@RequestParam String message) {
        log.info("Received message: {}", message);
        String response = chatClient
                .prompt(message)
                .call().content();
        return ResponseEntity.ok(response);
    }
}
