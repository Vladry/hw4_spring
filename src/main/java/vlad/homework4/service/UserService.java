package vlad.homework4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vlad.homework4.domain.SysUser;
import vlad.homework4.repository.UserRepository;
import vlad.homework4.repository.UserRepositoryEm;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositoryEm userRepositoryEm;
    private final UserRepository userRepository;

//    public SysUser save(SysUser user){
//        return userRepositoryEm.saveEntity(user);
//    }

    public SysUser save(SysUser user){
        System.out.println("in userService.save(user)");
        System.out.println("user: "+user);
        return userRepository.save(user);
    }


    public SysUser findSecurityUserByUsername(String name){
        return userRepository.findSecurityUserByUsername(name).orElse(null);
    }
}
