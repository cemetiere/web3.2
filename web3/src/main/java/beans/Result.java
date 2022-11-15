package beans;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity(name="results")
@Table(name="results", schema = "public")
public class Result implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Min(-4)@Max(4)
    private double x;
    @Min(-3)@Max(3)
    private double y;
    @Min(1)@Max(4)
    private double r;
    private LocalDateTime currentTime;
    private long executionTime;
    private boolean hitFact;

}