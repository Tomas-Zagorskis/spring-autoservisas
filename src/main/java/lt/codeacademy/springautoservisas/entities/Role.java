package lt.codeacademy.springautoservisas.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role implements GrantedAuthority {

    private static final String ROLE_PREFIX = "ROLE_";

    @Id
    private String name;

    @Override
    public String getAuthority() {
        return ROLE_PREFIX + name;
    }

    @Override
    public String toString() {
        return this.name;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }
}