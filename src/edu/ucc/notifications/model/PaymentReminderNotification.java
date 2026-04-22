package edu.ucc.notifications.model;

public class PaymentReminderNotification extends Notification {

    private double amountDue;
    private String dueDate;

    public PaymentReminderNotification(String code, String recipient, double amountDue, String dueDate) {
        super(code, recipient, "Recordatorio: El pago de tu matrícula por $" + String.format("%.2f", amountDue) + " vence el día " + dueDate + ".");
        this.amountDue = amountDue;
        this.dueDate = dueDate;
    }

    @Override
    public String getNotificationType() {
        return "Recordatorio de Pago de Matrícula";
    }

    public double getAmountDue() { return amountDue; }
    public String getDueDate() { return dueDate; }
}
