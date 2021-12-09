package liquidjoo.youthcon21springevent.sender.event.sub;

import liquidjoo.youthcon21springevent.sender.application.SenderService;
import liquidjoo.youthcon21springevent.sender.event.SendEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class SendEventHandler implements ApplicationListener<SendEvent> {

    private final SenderService senderService;

    public SendEventHandler(SenderService senderService) {
        this.senderService = senderService;
    }

    @Override
    public void onApplicationEvent(SendEvent event) {
        this.senderService.sendSMS(event.getPhoneNumber());
        this.senderService.sendEmail(event.getEmail());
    }
}
