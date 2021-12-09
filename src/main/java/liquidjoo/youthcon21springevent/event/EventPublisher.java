package liquidjoo.youthcon21springevent.event;

import liquidjoo.youthcon21springevent.sender.event.SendEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {
    private ApplicationEventPublisher eventPublisher;

    public EventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishEvent(Object event) {
        eventPublisher.publishEvent(event);
    }
}
