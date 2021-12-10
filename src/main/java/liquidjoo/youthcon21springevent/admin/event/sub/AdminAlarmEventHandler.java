package liquidjoo.youthcon21springevent.admin.event.sub;

import liquidjoo.youthcon21springevent.admin.event.AdminAlarmEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AdminAlarmEventHandler implements ApplicationListener<AdminAlarmEvent> {

    @Override
    public void onApplicationEvent(AdminAlarmEvent event) {
        log.info("어드민 서비스 : 환영합니다 {}", event.getName());
    }
}
