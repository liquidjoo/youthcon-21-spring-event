package liquidjoo.youthcon21springevent.user.domain;

import org.springframework.context.ApplicationEvent;

public class UserSenderEvent extends ApplicationEvent {

    private final String phoneNumber;
    private final String email;

    public UserSenderEvent(Object source, String phoneNumber, String email) {
        super(source);
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
