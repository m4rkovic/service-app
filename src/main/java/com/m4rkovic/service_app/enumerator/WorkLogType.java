package com.m4rkovic.service_app.enumerator;

public enum WorkLogType {
    ANALYSIS("Analysis"),
    DEVELOPMENT("Development"),
    TESTING("Testing"),
    COMMUNICATION("Communication"),
    DOCUMENTATION("Documentation"),
    DEPLOYMENT("Deployment"),
    MAINTENANCE("Maintenance"),
    SUPPORT("Support");

    private final String displayName;

    WorkLogType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}