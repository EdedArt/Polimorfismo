package edu.ucc.notifications.model;

import edu.ucc.notifications.strategy.NotificationStrategy;
import java.time.LocalDateTime;

public abstract class Notification {
    protected String code;
    protected String recipient;
    protected String message;
    protected LocalDateTime sentDate;
    protected NotificationStatus status;
    private NotificationStrategy strategy;

    public Notification(String code, String recipient, String message) {
        this.code = code;
        this.recipient = recipient;
        this.message = message;
        this.status = NotificationStatus.PENDING;
    }

    public void setStrategy(NotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void processNotification() {
        if (strategy == null) {
            System.out.println("❌ Error: No se ha asignado un medio de envío para la notificación " + code);
            this.status = NotificationStatus.FAILED;
            return;
        }
        
        try {
            boolean success = strategy.send(this);
            this.sentDate = LocalDateTime.now();
            
            if (success) {
                this.status = NotificationStatus.SENT;
            } else {
                this.status = NotificationStatus.FAILED;
            }
        } catch (Exception e) {
            this.status = NotificationStatus.FAILED;
            System.out.println("❌ Error enviando notificación: " + e.getMessage());
        }
    }

    // Método abstracto para que las subclases agreguen detalles específicos si lo desean
    public abstract String getNotificationType();

    // Getters y Setters
    public String getCode() { return code; }
    public String getRecipient() { return recipient; }
    public String getMessage() { return message; }
    public LocalDateTime getSentDate() { return sentDate; }
    public NotificationStatus getStatus() { return status; }
}
