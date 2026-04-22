package edu.ucc.notifications.model;

public enum NotificationStatus {
    PENDING("Pendiente"),
    SENT("Enviado"),
    FAILED("Fallido");

    private final String description;

    NotificationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
