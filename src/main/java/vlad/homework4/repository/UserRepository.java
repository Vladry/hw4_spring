package vlad.homework4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlad.homework4.domain.SysUser;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SysUser, Long> {
   public Optional<SysUser> findSecurityUserByUsername(String username);
}

