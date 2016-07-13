package com.orcanote.boilerplate.data.event;

public class WelcomingEvent {
    private String message;

    public WelcomingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
