package com.optxt.notesapp.userservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Note(String title, String content, @JsonProperty("id") long noteId) {
}
