package liquidjoo.youthcon21springevent.admin.event;

public class CouponEvent {
    private final String email;

    public CouponEvent(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
