package liquidjoo.youthcon21springevent.sender.event.sub;

import liquidjoo.youthcon21springevent.event.EventSubscriber;
import liquidjoo.youthcon21springevent.sender.application.SenderService;
import liquidjoo.youthcon21springevent.sender.event.SendEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class SendEventHandler implements EventSubscriber<SendEvent> {

    private final SenderService senderService;

    public SendEventHandler(SenderService senderService) {
        this.senderService = senderService;
    }

    @Override
    public void handleEvent(SendEvent event) {
        this.senderService.sendSMS(event.getPhoneNumber());
        this.senderService.sendEmail(event.getEmail());
    }
}
