package edu.ucc.notifications.model;

public class GradeNotification extends Notification {

    private String subject;
    private double grade;

    public GradeNotification(String code, String recipient, String subject, double grade) {
        super(code, recipient, "Tus calificaciones de la materia '" + subject + "' han sido publicadas. Nota: " + grade);
        this.subject = subject;
        this.grade = grade;
    }

    @Override
    public String getNotificationType() {
        return "Publicación de Calificaciones";
    }

    public String getSubject() { return subject; }
    public double getGrade() { return grade; }
}
