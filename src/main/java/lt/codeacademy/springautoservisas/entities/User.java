package lt.codeacademy.springautoservisas.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    private String username;

    private String password;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 45, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 45, nullable = false, name = "last_name")
    private String lastName;

    private int age;

    @ManyToMany
    private Set<Role> roles = new HashSet<>();;

    @Override
    public Set<Role> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
