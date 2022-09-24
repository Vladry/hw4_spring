package vlad.homework4.controller.auth;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    private final PasswordEncoder passwordEncoder;

    public AuthController(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
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


    @GetMapping("/logout")
    public void logout() {
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "/dashboard";
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/")
    public String homepage() {
        return "/dashboard";
    }
}
