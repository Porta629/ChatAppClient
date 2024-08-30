package de.lp.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.lp.model.Message;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Message parseMessage(String json) throws IOException {
        JsonNode rootNode = objectMapper.readTree(json);
        JsonNode messageNode = rootNode.get("message");

        if (messageNode != null) {
            String id = messageNode.get("id").asText();
            String timestamp = LocalDateTime.parse(messageNode.get("timestamp").asText()).toString();
            String sender = messageNode.get("sender").asText();
            String text = messageNode.get("text").asText();
            List<String> attachments = objectMapper.convertValue(messageNode.get("attachments"), List.class);

            return new Message(id, timestamp, sender, text, attachments);
        } else {
            throw new IOException("No message found in JSON.");
        }
    }
    public static String toJson(Message message) throws Exception {
        return objectMapper.writeValueAsString(message);
    }
}
