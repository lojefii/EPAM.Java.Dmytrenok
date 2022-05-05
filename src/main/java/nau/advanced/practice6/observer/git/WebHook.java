package nau.advanced.practice6.observer.git;

import java.util.List;

public interface WebHook {
    String branch();
    Event.Type type();
    List<Event> caughtEvents();
    void onEvent(Event event);
}