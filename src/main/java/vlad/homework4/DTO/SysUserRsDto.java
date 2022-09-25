package vlad.homework4.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import vlad.homework4.domain.AbstractEntity;
import vlad.homework4.domain.SysRoles;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
//@EqualsAndHashCode(callSuper = true)
public class SysUserRsDto extends AbstractEntity {
    private String username;
    private String password;

//    private Set<SysRoles> sysRoles = new HashSet<>(List.of(new SysRoles("USER")));

}
