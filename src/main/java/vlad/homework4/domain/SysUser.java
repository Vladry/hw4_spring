package vlad.homework4.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(of={"username", "role"})
@Table(name ="users")
public class SysUser extends AbstractEntity{
    @Column(name="user_name", length= 36, nullable = false)
    private String username;
    @Column(length = 128, nullable = false)
    private String password;
    @Column(name="account_non_expired", length = 1, nullable = false)
    private Boolean accountNonExpired = true;
    @Column(name="account_non_locked", length = 1, nullable = false)
    private Boolean accountNonLocked = true;
    @Column(name="credentials_non_expired", length = 1, nullable = false)
    private Boolean credentialsNonExpired = true;
    @Column(length = 1, nullable = false)
    private Boolean enabled = true;

    @OneToMany(mappedBy="sysUser", fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<SysRoles> sysRoles = new HashSet<>(List.of(new SysRoles("USER")));

}
