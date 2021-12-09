package liquidjoo.youthcon21springevent.event;

import org.springframework.context.event.EventListener;

public interface EventSubscriber<T> {

    @EventListener
    void handleEvent(T event);
}
