package com.orcanote.boilerplate.util;

import org.greenrobot.eventbus.EventBus;

public class EventBusUtils {

    private EventBusUtils() {
    }

    public static void register(Object object) {
        eventBus().register(object);
    }

    public static void unregister(Object object) {
        eventBus().unregister(object);
    }

    public static void post(Object object) {
        eventBus().post(object);
    }

    private static EventBus eventBus() {
        return EventBus.getDefault();
    }
}
