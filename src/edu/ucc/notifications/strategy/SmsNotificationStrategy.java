package edu.ucc.notifications.strategy;

import edu.ucc.notifications.model.Notification;

public class SmsNotificationStrategy implements NotificationStrategy {

    private String provider;

    public SmsNotificationStrategy(String provider) {
        this.provider = provider;
    }

    @Override
    public boolean send(Notification notification) {
        System.out.println("--------------------------------------------------");
        System.out.println("📱 [SMS] Usando proveedor: " + provider);
        System.out.println("📱 [SMS] Enviando mensaje de texto a: " + notification.getRecipient());
        System.out.println("📱 [SMS] Mensaje: " + notification.getMessage());
        System.out.println("📱 [SMS] ¡Mensaje de texto enviado con éxito!");
        System.out.println("--------------------------------------------------");
        return true;
    }
}
