package edu.ucc.notifications.service;

import edu.ucc.notifications.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
    
    private List<Notification> notificationHistory;

    public NotificationService() {
        this.notificationHistory = new ArrayList<>();
    }

    public void processAndSendNotification(Notification notification) {
        System.out.println(">>> Iniciando procesamiento de notificación: " + notification.getCode());
        System.out.println(">>> Situación: " + notification.getNotificationType());
        
        notification.processNotification();
        
        notificationHistory.add(notification);
        System.out.println(">>> Estado final: " + notification.getStatus().getDescription() + "\n");
    }

    public void showHistory() {
        System.out.println("=== HISTORIAL DE NOTIFICACIONES ===");
        for (Notification n : notificationHistory) {
            System.out.println(String.format("Código: %s | Tipo: %s | Destinatario: %s | Estado: %s",
                    n.getCode(), n.getNotificationType(), n.getRecipient(), n.getStatus().getDescription()));
        }
        System.out.println("===================================\n");
    }
}
