package com.orcanote.boilerplate.storage.repository.event;

public interface BaseEvent {

    /**
     * remove all dependencies
     */
    void destroy();
}
