package com.example.NotificationsObserver;

import javafx.animation.Animation;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class NotificationBuilder extends NotificationAbstract{
    private static NotificationType notificationType;
    public NotificationBuilder(Subject subject,String message, NotificationType notificationType) {
        this.message=message;
        this.subject=subject;
        this.notificationType=notificationType;
    }
    public NotificationBuilder() {

    }
    public static void createNotification(String text, String imageUrl){
       // Image image = new Image(imageUrl);
        Notifications notifications = Notifications.create();
        //notifications.graphic(new ImageView(image));
        notifications.title("EBD");
        notifications.text(text);
        notifications.graphic(null);
        notifications.hideAfter(Duration.seconds(4));
        notifications.darkStyle();
        notifications.position(Pos.BASELINE_CENTER);
        notifications.showConfirm();
    }
    public static void trayNotification(String message) {
        TrayNotification tray = new TrayNotification();
        AnimationType type = AnimationType.POPUP;
        tray.setAnimationType(type);
        tray.setTitle("EDB");
        tray.setMessage(message);
        tray.setNotificationType(notificationType);
        tray.showAndDismiss(Duration.seconds(4));
    }

    @Override
    public void notifyUser() {
        System.out.println("Hello in Notification Builder");
        trayNotification(this.message);
    }
}
