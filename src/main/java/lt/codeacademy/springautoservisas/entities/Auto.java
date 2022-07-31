package lt.codeacademy.springautoservisas.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "autos")
public class Auto implements Serializable {

    @Id
    @NotBlank
    @Size(min=1, max=10)
    @Column(name = "plate_nr")
    private String plateNr;

    @Column(name = "registration_time")
    private String regTime;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @Digits(integer = 4, fraction = 0)
    @Positive
    @NotBlank
    private String year;

    @Size(max=255)
    private String issue;
    private boolean fixed;

    @Digits(integer = 5, fraction = 2)
    @PositiveOrZero
    @NotNull
    private Double costs;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="client_id", nullable=false)
    private Client client;

}
