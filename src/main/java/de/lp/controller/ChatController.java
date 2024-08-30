package de.lp.controller;

import de.lp.model.Message;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class ChatController {
    private final ChatClient chatClient;

    public ChatController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public void sendMessage(String sender, String text) throws Exception {
        Message message = new Message("some-id", LocalDateTime.now().toString(), sender, text, List.of());
        chatClient.sendMessage(message);
    }

    public void receiveMessages() throws Exception {
        Message message = chatClient.receiveMessage();
        System.out.println("Received message: " + message);
    }

    public void closeClient() throws IOException {
        chatClient.close();
    }
}