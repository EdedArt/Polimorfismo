package edu.ucc.notifications.model;

public class ClassCancellationNotification extends Notification {

    private String className;
    private String reason;

    public ClassCancellationNotification(String code, String recipient, String className, String reason) {
        super(code, recipient, "Aviso: La clase '" + className + "' ha sido cancelada. Motivo: " + reason);
        this.className = className;
        this.reason = reason;
    }

    @Override
    public String getNotificationType() {
        return "Aviso de Cancelación de Clase";
    }

    public String getClassName() { return className; }
    public String getReason() { return reason; }
}
