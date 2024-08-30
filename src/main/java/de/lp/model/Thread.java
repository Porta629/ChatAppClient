package de.lp.model;

import java.util.List;

public record Thread(String id, String name, List<Message> messages) {}
