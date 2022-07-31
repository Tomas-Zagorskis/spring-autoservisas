package lt.codeacademy.springautoservisas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "clients")
public class Client implements Serializable {

    @Id
    @Type(type = "uuid-char")
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @Column(unique = true)
    @NotBlank
    @Email
    private String email;

    @Column(name = "phone_nr")
    @NotBlank
    private String phoneNr;

    @NotBlank
    private String city;

    @NotBlank
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Auto> autos = new ArrayList<>();

    public String getFullName() {
        return name + ' ' + surname;
    }
}
