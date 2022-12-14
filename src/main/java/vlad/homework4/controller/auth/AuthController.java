package vlad.homework4.controller.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import vlad.homework4.DTO.SysUserRsDto;
import vlad.homework4.DTO.UserCredentialsRqDto;
import vlad.homework4.domain.SysUser;
import vlad.homework4.service.UserService;

@Controller
public class AuthController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public AuthController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "/register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("in @GetMapping(\"/login\") ->");

        model.addAttribute("suggestedUser", "user");
        model.addAttribute("suggestedPassword", "pw");
        return "/login";
    }

/*    @PostMapping("/login")
    public String loginFromForm(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("in @PostMapping(\"/login\") ->");
        //        String pwFromDB = "asdfhawe";
        String encodedPw = passwordEncoder.encode(password);
        boolean pwMatches = passwordEncoder.matches(password, encodedPw);
        System.out.println("username: "+ username);
        System.out.println("suggestedPassword: " + password);
        System.out.println("encodedPw: " + encodedPw);
        System.out.println("pwMatches: " + pwMatches);
        return "/dashboard";
    }*/


    @PostMapping("/users/create2")
    public String register2(
            @RequestParam("login") String login,
            @RequestParam("password") String password) {

        System.out.println("in register2-> ");
        SysUser sysUser = null;
        try {
            sysUser = userService.findSecurityUserByUsername(login);
            if (sysUser == null) {
                SysUser user = new SysUser(login, passwordEncoder.encode(password));
                userService.save(user);

            } else {
                System.out.println("user already exists");
                throw new RuntimeException("user already exists");
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return "/login";
    }


    @GetMapping("/logout")
    public void logout(Model model) {
    }

//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @GetMapping("/dashboard")
//    public String dashboard() {
//        return "/dashboard";
//    }

    @GetMapping("/")
    public String homepage() {
        return "/login";
    }
}
