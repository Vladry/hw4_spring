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
        return userRepository.save(user);
    }
}
