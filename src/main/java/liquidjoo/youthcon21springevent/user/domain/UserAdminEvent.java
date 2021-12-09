package liquidjoo.youthcon21springevent.user.domain;

import org.springframework.context.ApplicationEvent;

public class UserAdminEvent extends ApplicationEvent {

    private final String username;

    public UserAdminEvent(Object source, String username) {
        super(source);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
