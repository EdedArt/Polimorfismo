package edu.ucc.notifications.strategy;

import edu.ucc.notifications.model.Notification;

public class AppNotificationStrategy implements NotificationStrategy {

    private String apiKey;

    public AppNotificationStrategy(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public boolean send(Notification notification) {
        System.out.println("--------------------------------------------------");
        System.out.println("🔔 [APP PUSH] Autenticando con API Key: " + apiKey.substring(0, Math.min(6, apiKey.length())) + "...");
        System.out.println("🔔 [APP PUSH] Enviando notificación push al dispositivo/token: " + notification.getRecipient());
        System.out.println("🔔 [APP PUSH] Tipo: " + notification.getNotificationType());
        System.out.println("🔔 [APP PUSH] Contenido: " + notification.getMessage());
        System.out.println("🔔 [APP PUSH] ¡Notificación Push entregada al dispositivo!");
        System.out.println("--------------------------------------------------");
        return true;
    }
}
