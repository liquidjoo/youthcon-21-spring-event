package liquidjoo.youthcon21springevent.user.application;

import liquidjoo.youthcon21springevent.admin.application.AdminService;
import liquidjoo.youthcon21springevent.admin.application.CouponService;
import liquidjoo.youthcon21springevent.sender.application.SenderService;
import liquidjoo.youthcon21springevent.user.domain.User;
import liquidjoo.youthcon21springevent.user.domain.UserRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final SenderService senderService;
    private final CouponService couponService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public UserService(UserRepository userRepository, SenderService senderService, CouponService couponService, ApplicationEventPublisher applicationEventPublisher) {
        this.userRepository = userRepository;
        this.senderService = senderService;
        this.couponService = couponService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void create(UserRequest userRequest) {
        User user = new User(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPhoneNumber()
        );
        userRepository.save(user);

        user.adminAlarmPublish(applicationEventPublisher);

        couponService.register(user.getEmail());
        senderService.sendSMS(user.getPhoneNumber());
        senderService.sendEmail(user.getEmail());
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
