package com.m4rkovic.service_app.enumerator;

public enum UserRole {
    SUPER_ADMIN("Super Administrator"),
    ADMIN("Administrator"),
    GROUP_MANAGER("Group Manager"),
    TECHNICIAN("Technician"),
    USER("Regular User");

    private final String displayName;

    UserRole(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}