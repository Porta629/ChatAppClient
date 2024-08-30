package de.lp.model;

import java.time.LocalDateTime;
import java.util.List;

public record Message(String id, String timestamp, String sender, String text, List<String> attachments) {}