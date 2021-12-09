package liquidjoo.youthcon21springevent.user.ui;

import liquidjoo.youthcon21springevent.user.application.UserRequest;
import liquidjoo.youthcon21springevent.user.application.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Void> create(@RequestBody UserRequest userRequest) {
        userService.create(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
