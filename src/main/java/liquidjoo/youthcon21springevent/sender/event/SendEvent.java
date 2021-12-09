package liquidjoo.youthcon21springevent.sender.event;

public class SendEvent {
    private final String phoneNumber;
    private final String email;

    public SendEvent(String phoneNumber, String email) {
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
