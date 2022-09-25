package vlad.homework4.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

    @PostMapping("/users/create")
    public SysUser register(
            @RequestBody UserCredentialsRqDto credentials) {
        System.out.println("in register-> ");
        String login = credentials.getLogin();
        SysUser sysUser = null;
        try {
            sysUser = userService.findSecurityUserByUsername(login);
            if (sysUser == null) {
                String password = credentials.getPassword();
                SysUser user = new SysUser(login, passwordEncoder.encode(password));
                System.out.println("saving new user: "+ user);
                return userService.save(user);
            } else {
                System.out.println("user already exists");
                throw new RuntimeException("user already exists");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return sysUser;
        }

    }
/*
    @PostMapping("/users/create2")
    public SysUser register2(
            @RequestParam("login") String login,
            @RequestParam("password") String password) {

        System.out.println("in register2-> ");
        SysUser sysUser = null;
        try {
            sysUser = userService.findSecurityUserByUsername(login);
            if (sysUser == null) {
                SysUser user = new SysUser(login, passwordEncoder.encode(password));

                return userService.save(user);
            } else {
                System.out.println("user already exists");
                throw new RuntimeException("user already exists");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return sysUser;
        }

    }*/
}
