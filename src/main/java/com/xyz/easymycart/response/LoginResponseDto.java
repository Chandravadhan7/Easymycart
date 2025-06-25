package com.xyz.easymycart.response;

public class LoginResponseDto {

  private String sessionId;

  private Long expiryAt;

  private Long userId;

  private String userName;

  public Long getUserId() {
    return userId;
  }

  public void setUserid(Long userId) {
    this.userId = userId;
  }

  public String getSessionId() {
    return sessionId;
  }

  public void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public Long getExpiryAt() {
    return expiryAt;
  }

  public void setExpiryAt(Long expiryAt) {
    this.expiryAt = expiryAt;
  }

  public LoginResponseDto(String sessionId, Long expiryAt, Long userId, String userName) {
    this.sessionId = sessionId;
    this.expiryAt = expiryAt;
    this.userId = userId;
      this.userName = userName;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
