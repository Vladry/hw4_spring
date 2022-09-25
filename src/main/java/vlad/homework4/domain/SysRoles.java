package vlad.homework4.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name="roles")
public class SysRoles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private SysUser sysUser;
    private String role;

    public SysRoles(String role){
        this.role=role;
    }

    public String toString(){
        return
                "role: " +
                role
                ;
    }
}
