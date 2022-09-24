package vlad.homework4.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DbSecurityConfig {
    //  https://www.thymeleaf.org/doc/articles/springsecurity.html

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
       // конфигурация для логина по ВЕБ-форме:
                .csrf().disable()
                .authorizeRequests()
                .antMatchers( "/login", "/logout", "/h2-console").permitAll()
//  TODO разообраться чего не работает hasRole():    .antMatchers("/").hasRole("USER")
//                .antMatchers().hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
//                .httpBasic()   //используем basic аутентификацию
//                .and()
                .formLogin()// указывает, что мы будем логиниться с формы
                .loginPage("/login")// эта форма будет доступна по этому URL-у
                .permitAll()// и, туда мы пускаем всех
                .and()
                .logout()    //описывает как будет осуществлять логаут:
                .invalidateHttpSession(true) //при этом, будем уничтожать сессию
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/http://BADNAME@localhost:9000/login") // и, потом будет авто-переход на этот адрес
                .permitAll() //и логаут будет доступен для всех
        ;
        return http.build();
    }

//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
