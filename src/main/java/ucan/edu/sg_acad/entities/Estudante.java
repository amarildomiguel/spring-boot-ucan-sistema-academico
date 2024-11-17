package ucan.edu.sg_acad.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
@Entity(name = "estudantes")
public class Estudante {

    @Id
    @Column(name = "pkEstudante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkEstudante;

    @Column(name = "numero_estudante", nullable = false)
    private String numeroEstudante;

    @OneToOne
    @JoinColumn(name = "fkPessoa")
    private Pessoa pessoa;

}