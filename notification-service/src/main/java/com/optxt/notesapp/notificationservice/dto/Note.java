package com.optxt.notesapp.notificationservice.dto;

public record Note(String title, String content, long id, long userId, String createdAt) {
}
