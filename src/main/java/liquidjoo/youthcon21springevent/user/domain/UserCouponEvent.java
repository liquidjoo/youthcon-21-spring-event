package liquidjoo.youthcon21springevent.user.domain;

import org.springframework.context.ApplicationEvent;

public class UserCouponEvent extends ApplicationEvent {

    private final String email;

    public UserCouponEvent(Object source, String email) {
        super(source);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
