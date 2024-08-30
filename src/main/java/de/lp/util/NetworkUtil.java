package de.lp.util;

import java.io.IOException;
import java.net.Socket;

public class NetworkUtil {
    private Socket socket;

    public void connect(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public void send(String message) throws IOException {
        socket.getOutputStream().write(message.getBytes());
    }

    public String receive() throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead = socket.getInputStream().read(buffer);
        return new String(buffer, 0, bytesRead);
    }

    public void close() throws IOException {
        socket.close();
    }
}
