package com.orcanote.boilerplate.storage.repository.event;

public class WelcomingEvent implements BaseEvent {
    private String message;

    public WelcomingEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public void destroy() {
        message = null;
    }
}
