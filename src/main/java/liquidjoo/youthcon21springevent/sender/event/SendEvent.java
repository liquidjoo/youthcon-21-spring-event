package liquidjoo.youthcon21springevent.sender.event;

import org.springframework.context.ApplicationEvent;

public class SendEvent extends ApplicationEvent {
    private final String phoneNumber;
    private final String email;

    public SendEvent(Object source, String phoneNumber, String email) {
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
