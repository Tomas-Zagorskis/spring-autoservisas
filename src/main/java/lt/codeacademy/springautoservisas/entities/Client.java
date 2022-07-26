package lt.codeacademy.springautoservisas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
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

    private String name;
    private String surname;
    @Column(unique = true)
    private String email;

    @Column(name = "phone_nr")
    private String phoneNr;
    private String city;
    private String address;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Auto> autos = new ArrayList<>();

    public String getFullName() {
        return name + ' ' + surname;
    }
}
