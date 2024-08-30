package de.lp;

import de.lp.controller.ChatClient;
import de.lp.controller.ChatController;

public class Main {
     public static void main(String[] args) {
         try {
             ChatClient chatClient = new ChatClient();
             ChatController chatController = new ChatController(chatClient);
             chatController.sendMessage("Alice", "Hallo Welt");
             //chatController.receiveMessages();

             chatController.closeClient();
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
 }
