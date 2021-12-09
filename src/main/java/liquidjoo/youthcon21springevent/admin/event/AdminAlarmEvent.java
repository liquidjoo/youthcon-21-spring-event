package liquidjoo.youthcon21springevent.admin.event;

import org.springframework.context.ApplicationEvent;

public class AdminAlarmEvent extends ApplicationEvent {
    private final String name;

    public AdminAlarmEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
