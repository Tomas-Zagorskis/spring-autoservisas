package lt.codeacademy.springautoservisas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "autos")
public class Auto implements Serializable {

    @Id
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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

}
