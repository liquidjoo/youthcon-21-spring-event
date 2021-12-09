package liquidjoo.youthcon21springevent.sender.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SenderService {

    public void sendSMS(String phoneNumber) {
        log.info("문자 메시지 발송 성공 : {}", phoneNumber);
    }

    public void sendEmail(String email) {
        log.info("이메일 발송 성공 : {}", email);
    }
}
