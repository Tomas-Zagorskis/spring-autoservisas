package lt.codeacademy.springautoservisas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "records")
public class RecordOfService implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Type(type = "uuid-char")
    @Column(name = "client_id")
    private UUID clientId;
    @Column(name = "plate_nr")
    private String plateNr;
    @Column(name = "registration_time")
    private String regTime;
    private String brand;
    private String model;
    private String year;
    private String issue;
    private boolean fixed;
    private double costs;
}
