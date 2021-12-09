package liquidjoo.youthcon21springevent.admin.event.sub;

import liquidjoo.youthcon21springevent.admin.application.AdminService;
import liquidjoo.youthcon21springevent.admin.event.AdminAlarmEvent;
import liquidjoo.youthcon21springevent.event.EventSubscriber;
import org.springframework.stereotype.Service;

@Service
public class AdminAlarmEventHandler implements EventSubscriber<AdminAlarmEvent> {
    private final AdminService adminService;

    public AdminAlarmEventHandler(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void handleEvent(AdminAlarmEvent event) {
        this.adminService.alarm(event.getName());
    }
}
