package vlad.homework4.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vlad.homework4.DTO.UserCredentialsRqDto;
import vlad.homework4.domain.SysUser;
import vlad.homework4.service.UserService;

@RestController
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public UserController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/users/create")
    public SysUser register(
            @RequestBody UserCredentialsRqDto credentials) {
        String login = credentials.getLogin();
        String password = credentials.getPassword();
        SysUser user = new SysUser(login, passwordEncoder.encode(password));
        return userService.save(user);
    }
}
