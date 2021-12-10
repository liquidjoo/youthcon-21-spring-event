package liquidjoo.youthcon21springevent.sender.event.sub;

import liquidjoo.youthcon21springevent.sender.application.SenderService;
import liquidjoo.youthcon21springevent.sender.event.SendEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SendEventHandler implements ApplicationListener<SendEvent> {

    @Override
    public void onApplicationEvent(SendEvent event) {
        log.info("문자 메시지 발송 성공 : {}", event.getPhoneNumber());
        log.info("이메일 발송 성공 : {}", event.getEmail());
    }
}
