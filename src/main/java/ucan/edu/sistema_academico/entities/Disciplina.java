package ucan.edu.sistema_academico.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "disciplinas")
public class Disciplina {

    @Id
    @Column(name = "pk_disciplina")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pkDisciplina;

    @Column(name = "nome", nullable = false)
    private String nome;

}
