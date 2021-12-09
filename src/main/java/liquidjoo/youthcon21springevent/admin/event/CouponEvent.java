package liquidjoo.youthcon21springevent.admin.event;

import org.springframework.context.ApplicationEvent;

public class CouponEvent extends ApplicationEvent {
    private final String email;

    public CouponEvent(Object source, String email) {
        super(source);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
