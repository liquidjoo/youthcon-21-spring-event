package liquidjoo.youthcon21springevent.admin.event.sub;

import liquidjoo.youthcon21springevent.admin.application.AdminService;
import liquidjoo.youthcon21springevent.admin.event.AdminAlarmEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class AdminAlarmEventHandler implements ApplicationListener<AdminAlarmEvent> {
    private final AdminService adminService;

    public AdminAlarmEventHandler(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void onApplicationEvent(AdminAlarmEvent event) {
        this.adminService.alarm(event.getName());
    }
}
