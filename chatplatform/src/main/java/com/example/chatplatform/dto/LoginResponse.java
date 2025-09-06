package com.example.chatplatform.dto;

public class LoginResponse {
    private String token;
    private UserDto user;

    public LoginResponse(String token) {
        this.token = token;
    }

    public LoginResponse(String token, UserDto user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() { return token; }
    public UserDto getUser() { return user; }

    // DTO để trả về user an toàn (ẩn password)
    public static class UserDto {
        private Long id;
        private String username;

        public UserDto(Long id, String username) {
            this.id = id;
            this.username = username;
        }

        public Long getId() { return id; }
        public String getUsername() { return username; }
    }
}
