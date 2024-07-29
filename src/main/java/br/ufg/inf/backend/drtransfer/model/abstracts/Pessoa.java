package br.ufg.inf.backend.drtransfer.model.abstracts;

import br.ufg.inf.backend.drtransfer.enumeradores.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Pessoa extends SuperClass {

    @Column(nullable = false)
    @Schema(description = "Nome", example = "Alexsandro")
    private String nome;

    @Column(unique = true)
    @Schema(description = "CPF", example = "999.999.999-99")
    private String cpf;

    @Schema(description = "Telefone", example = "62 9999-9999")
    private String telefone;

    @Schema(description = "Email", example = "alexsandro@hogwarts.medic")
    private String email;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Sexo", example = "MASCULINO")
    private Sexo sexo;
}
