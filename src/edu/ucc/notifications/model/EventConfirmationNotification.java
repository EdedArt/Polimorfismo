package edu.ucc.notifications.model;

public class EventConfirmationNotification extends Notification {

    private String eventName;
    private String eventLocation;

    public EventConfirmationNotification(String code, String recipient, String eventName, String eventLocation) {
        super(code, recipient, "Confirmación: Te has inscrito exitosamente al evento '" + eventName + "'. Lugar: " + eventLocation);
        this.eventName = eventName;
        this.eventLocation = eventLocation;
    }

    @Override
    public String getNotificationType() {
        return "Confirmación de Inscripción a Eventos";
    }

    public String getEventName() { return eventName; }
    public String getEventLocation() { return eventLocation; }
}
