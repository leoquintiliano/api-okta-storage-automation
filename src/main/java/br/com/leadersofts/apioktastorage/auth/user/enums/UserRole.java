package br.com.leadersofts.apioktastorage.auth.user.enums;

public enum UserRole {

    ADMIN("admin"),
    USER("role");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
