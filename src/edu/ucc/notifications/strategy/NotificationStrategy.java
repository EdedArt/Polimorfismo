package edu.ucc.notifications.strategy;

import edu.ucc.notifications.model.Notification;

public interface NotificationStrategy {
    /**
     * Send a notification with the implemented method
     * @param notification Notification data
     * @return boolean indicating success
     */
    boolean send(Notification notification);
}
