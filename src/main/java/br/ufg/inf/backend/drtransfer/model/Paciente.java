package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
import br.ufg.inf.backend.drtransfer.enumeradores.TipoSanguineo;
import br.ufg.inf.backend.drtransfer.model.abstracts.Pessoa;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Paciente extends Pessoa {

    @Schema(description = "Data Nascimento", example = "2024-07-27")
    private LocalDate dataNascimento;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Schema(description = "Tipo Sanguineo", example = "A_POSITIVO")
    private TipoSanguineo tipoSanguineo;

    @OneToOne
    @JsonManagedReference
    @Schema(description = "Prontuario")
    private Prontuario prontuario;


    public Paciente(String nome, String cpf, String telefone, String email, Sexo sexo, LocalDate dataNascimento, TipoSanguineo tipoSanguineo) {
        super(nome, cpf, telefone, email, sexo);
        this.dataNascimento = dataNascimento;
        this.tipoSanguineo = tipoSanguineo;
    }
}
