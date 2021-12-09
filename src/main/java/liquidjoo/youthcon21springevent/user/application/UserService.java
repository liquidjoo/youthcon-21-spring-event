package liquidjoo.youthcon21springevent.user.application;

import liquidjoo.youthcon21springevent.admin.application.AdminService;
import liquidjoo.youthcon21springevent.admin.application.CouponService;
import liquidjoo.youthcon21springevent.sender.application.SenderService;
import liquidjoo.youthcon21springevent.user.domain.User;
import liquidjoo.youthcon21springevent.user.domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final AdminService adminService;
    private final SenderService senderService;
    private final CouponService couponService;

    public UserService(UserRepository userRepository, AdminService adminService, SenderService senderService, CouponService couponService) {
        this.userRepository = userRepository;
        this.adminService = adminService;
        this.senderService = senderService;
        this.couponService = couponService;
    }

    public void create(UserRequest userRequest) {
        User user = new User(
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getPhoneNumber()
        );
        userRepository.save(user);

        adminService.alarm(user.getName());
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
