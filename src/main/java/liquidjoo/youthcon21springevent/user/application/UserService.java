package liquidjoo.youthcon21springevent.user.application;

import liquidjoo.youthcon21springevent.admin.event.AdminAlarmEvent;
import liquidjoo.youthcon21springevent.admin.event.CouponEvent;
import liquidjoo.youthcon21springevent.event.EventPublisher;
import liquidjoo.youthcon21springevent.sender.event.SendEvent;
import liquidjoo.youthcon21springevent.user.domain.User;
import liquidjoo.youthcon21springevent.user.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final EventPublisher eventPublisher;

    public UserService(UserRepository userRepository, EventPublisher eventPublisher) {
        this.userRepository = userRepository;
        this.eventPublisher = eventPublisher;
    }

    public void create(UserRequest userRequest) {
        User user = new User(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPhoneNumber()
        );
        userRepository.save(user);
        eventPublisher.publishEvent(new SendEvent(this, user.getEmail(), user.getPhoneNumber()));
        eventPublisher.publishEvent(new CouponEvent(this, user.getEmail()));
        eventPublisher.publishEvent(new AdminAlarmEvent(this, user.getName()));
    }

    public UserResponse get(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException(""));

        return new UserResponse(
                user.getName(),
                user.getEmail(),
                user.getPhoneNumber()
        );
    }
}
