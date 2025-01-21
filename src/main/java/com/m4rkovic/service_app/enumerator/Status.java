package com.m4rkovic.service_app.enumerator;

public enum Status {
    NEW("New"),                           // Just created, not yet assigned
    ASSIGNED("Assigned"),                 // Assigned to group/individual but work not started
    IN_PROGRESS("In Progress"),           // Being actively worked on
    ON_HOLD("On Hold"),                   // Temporarily stopped (waiting for info/approval)
    PENDING_CUSTOMER("Pending Customer"), // Waiting for customer response
    RESOLVED("Resolved"),                 // Solution provided but not yet confirmed
    CLOSED("Closed"),                     // Completely finished and verified
    CANCELLED("Cancelled");               // Terminated without resolution

    private final String displayName;

    Status(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}