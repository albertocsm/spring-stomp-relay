package com.github.albertocsm.ssr;

import java.time.LocalDateTime;
import java.util.UUID;

public class Message {

  private String content;
  private String id = UUID.randomUUID().toString();
  private LocalDateTime date = LocalDateTime.now();
  private String sender;

  private Message() {

  }

  private Message(
      String content,
      String sender) {

    this.content = content;
    this.sender = sender;
    date = LocalDateTime.now();
  }

  protected void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public String getSender() {
    return sender;
  }

  public String getId() {
    return id;
  }

  public Message content(final String content) {
    this.content = content;
    return this;
  }

  public Message id(final String id) {
    this.id = id;
    return this;
  }

  public Message date(final LocalDateTime date) {
    this.date = date;
    return this;
  }

  public Message sender(final String sender) {
    this.sender = sender;
    return this;
  }
}
