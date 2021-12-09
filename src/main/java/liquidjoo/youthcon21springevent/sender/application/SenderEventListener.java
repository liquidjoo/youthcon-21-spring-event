package liquidjoo.youthcon21springevent.sender.application;

import liquidjoo.youthcon21springevent.user.domain.UserSenderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SenderEventListener {

    @EventListener
    public void sms(UserSenderEvent userSenderEvent) {
        log.info("문자 메시지 발송 성공 : {}", userSenderEvent.getPhoneNumber());
    }

    @EventListener
    public void email(UserSenderEvent userSenderEvent) {
        log.info("이메일 발송 성공 : {}", userSenderEvent.getEmail());
    }
}
