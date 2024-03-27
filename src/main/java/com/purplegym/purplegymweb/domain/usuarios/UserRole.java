package com.purplegym.purplegymweb.domain.usuarios;

public enum UserRole {

    ADMIN("admin"),
    USER("user"),
    GUEST("guest"),
    APP("app");

    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
