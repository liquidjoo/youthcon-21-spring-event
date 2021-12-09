package liquidjoo.youthcon21springevent.user.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.ApplicationEventPublisher;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public User(String name, String email, String phoneNumber) {
        this(null, name, email, phoneNumber, null, null);
    }

    private User(Long id, String name, String email, String phoneNumber, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    protected User() {

    }

    public void eventPublish(ApplicationEventPublisher applicationEventPublisher) {
        adminAlarmPublish(applicationEventPublisher);
        senderPublish(applicationEventPublisher);
        couponPublish(applicationEventPublisher);
    }

    private void adminAlarmPublish(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new UserAdminEvent(this, this.name));
    }

    private void senderPublish(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new UserSenderEvent(this, this.phoneNumber, this.email));
    }

    private void couponPublish(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent(new UserCouponEvent(this, this.email));
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
