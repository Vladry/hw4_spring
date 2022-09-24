package vlad.homework4.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name="roles")
public class SysRoles {

    @Id
    private Long id;
    @ManyToOne
    private SysUser sysUser;
    private String role;

    public SysRoles(String role){
        this.role=role;
    }

    public String toString(){
        return "\n"+ this.getClass().getName() + "-> "+
//                "{id:" +
//                id +
                "sysUser: " +
                sysUser +
                ", role: " +
                role +
                " }"
                ;
    }
}
