package edu.ucc.notifications.strategy;

import edu.ucc.notifications.model.Notification;

public class EmailNotificationStrategy implements NotificationStrategy {

    private String smtpServer;
    private int port;

    public EmailNotificationStrategy(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    @Override
    public boolean send(Notification notification) {
        System.out.println("--------------------------------------------------");
        System.out.println("📧 [EMAIL] Conectando al servidor SMTP " + smtpServer + ":" + port + "...");
        System.out.println("📧 [EMAIL] Enviando correo electrónico a: " + notification.getRecipient());
        System.out.println("📧 [EMAIL] Asunto: " + notification.getNotificationType());
        System.out.println("📧 [EMAIL] Cuerpo del Mensaje: " + notification.getMessage());
        System.out.println("📧 [EMAIL] ¡Correo enviado con éxito!");
        System.out.println("--------------------------------------------------");
        return true;
    }
}
