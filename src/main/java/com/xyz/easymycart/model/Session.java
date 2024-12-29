package com.xyz.easymycart.model;

import javax.persistence.*;

@Entity
@Table(name = "session")
public class Session {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "session_id", nullable = false, unique = true)
  private String sessionId;

  @Column(name = "user_id", nullable = false)
  private Long userId;

  @Column(name = "expires_at", nullable = false)
  private Long expiresAt;

  public Session(String sessionId, Long userId, Long expiresAt) {
    this.sessionId = sessionId;
    this.userId = userId;
    this.expiresAt = expiresAt;
  }

  public Session() {}

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getUserId() {
    return userId;
  }

  public String getSessionId() {
    return sessionId;
  }

  public Long getExpiresAt() {
    return expiresAt;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public void setExpiresAt(Long expiresAt) {
    this.expiresAt = expiresAt;
  }
}
