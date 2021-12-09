package liquidjoo.youthcon21springevent.admin.event;

public class AdminAlarmEvent {
    private final String name;

    public AdminAlarmEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
