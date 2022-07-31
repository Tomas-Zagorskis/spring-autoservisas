package lt.codeacademy.springautoservisas.entities;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(nullable = false, unique = true, length = 36)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(length = 20)
    private String password;

    @Column(nullable = false, unique = true, length = 45)
    private String email;

    @Column(length = 45, nullable = false, name = "first_name")
    private String firstName;

    @Column(length = 45, nullable = false, name = "last_name")
    private String lastName;

    private int age;
}
