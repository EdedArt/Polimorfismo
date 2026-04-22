package edu.ucc.notifications;

import edu.ucc.notifications.model.*;
import edu.ucc.notifications.service.NotificationService;
import edu.ucc.notifications.strategy.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("   SISTEMA DE NOTIFICACIONES UNIVERSIDAD  ");
        System.out.println("==========================================\n");

        // 1. Inicializamos el servicio de notificaciones
        NotificationService service = new NotificationService();

        // 2. Definimos nuestras estrategias (medios de envío)
        NotificationStrategy emailStrategy = new EmailNotificationStrategy("smtp.universidad.edu.co", 587);
        NotificationStrategy smsStrategy = new SmsNotificationStrategy("Twilio SMS");
        NotificationStrategy appStrategy = new AppNotificationStrategy("FIREBASE_KEY_998877");

        // 3. Creamos diferentes situaciones de notificación

        // Situación A: Publicación de calificaciones (Vía Email)
        Notification gradeNotif = new GradeNotification("N-001", "estudiante1@campusucc.edu.co", "Diseño de Software", 4.5);
        gradeNotif.setStrategy(emailStrategy);

        // Situación B: Recordatorio de pago de matrícula (Vía SMS)
        Notification paymentNotif = new PaymentReminderNotification("N-002", "+573001234567", 2500000.00, "15 de Mayo de 2026");
        paymentNotif.setStrategy(smsStrategy);

        // Situación C: Aviso de cancelación de clase (Vía App Móvil a todos los inscritos)
        Notification cancelNotif = new ClassCancellationNotification("N-003", "DIS_SOFT_GRP_1", "Ingeniería de Requisitos", "Profesor incapacitado por salud.");
        cancelNotif.setStrategy(appStrategy);

        // Situación D: Confirmación de inscripción a eventos académicos (Vía Email)
        Notification eventNotif = new EventConfirmationNotification("N-004", "estudiante2@campusucc.edu.co", "Congreso Nacional de TI", "Auditorio Principal UCC");
        eventNotif.setStrategy(emailStrategy);

        // 4. Procesamos y enviamos
        service.processAndSendNotification(gradeNotif);
        service.processAndSendNotification(paymentNotif);
        service.processAndSendNotification(cancelNotif);
        service.processAndSendNotification(eventNotif);

        // 5. Mostramos el historial guardado
        service.showHistory();

        System.out.println("==========================================");
        System.out.println("Demostración finalizada exitosamente.");
    }
}
