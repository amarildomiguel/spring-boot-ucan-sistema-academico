package ucan.edu.sg_acad.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "plano_curso")
public class PlanoCurso {
    @Id
    @Column(name = "pk_curso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkPlanoCurso;

    @Column(name = "semestre", nullable = false)
    private int semestre;

    @ManyToOne
    @JoinColumn(name = "fk_disciplina")
    private Disciplina disciplina;

    @ManyToOne()
    @JsonBackReference  // para gerenciar a serialização bidirecional evitando a recursão infinita
    @JoinColumn(name = "fk_curso")
    private Curso curso;


}
