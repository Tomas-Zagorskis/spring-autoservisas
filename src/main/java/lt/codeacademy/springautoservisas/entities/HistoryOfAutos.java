package lt.codeacademy.springautoservisas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "history")
public class HistoryOfAutos {

    @Id
    @Type(type = "uuid-char")
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
