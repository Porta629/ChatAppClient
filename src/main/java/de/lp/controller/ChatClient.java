package de.lp.controller;

import de.lp.config.ClientConfig;
import de.lp.model.Message;
import de.lp.util.JsonUtil;

import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private SecretKeySpec keySpec;

    public ChatClient() throws Exception {
        this.socket = new Socket(ClientConfig.SERVER_HOST, ClientConfig.SERVER_PORT);
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendMessage(Message message) throws Exception {
        String jsonMessage = JsonUtil.toJson(message);
        socket.getOutputStream().write(jsonMessage.getBytes());
        out.println(jsonMessage);
    }

    public Message receiveMessage() throws Exception {
        String jsonMessage = String.valueOf(socket.getInputStream().read());
        return JsonUtil.parseMessage(jsonMessage);
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
