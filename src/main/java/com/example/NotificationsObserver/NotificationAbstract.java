package com.example.NotificationsObserver;

public abstract class NotificationAbstract  {

    String message;
    protected Subject subject;
    public abstract void notifyUser();

    // should be send to the push notifications and email at the same time
    // same message


}
