package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.utils.SwaggerView;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital extends SuperClass {

    @Schema(description = "Nome", example = "HGG")
    private String nome;

    @Schema(description = "Telefone", example = "62 0000-0000")
    private String telephoneNumber;

    @Schema(description = "Email", example = "hospital@hgg.com")
    private String email;

    @Schema(description = "Latitude", example = "-16.54512313")
    private Double latitute;

    @Schema(description = "Longitude", example = "-14.45461223")
    private Double longitude;

    @Schema(description = "Quantidade de leitos disponíveis", example = "10")
    private Integer availableBeds;

    @Schema(description = "Existe UTI no hospital", example = "true")
    private boolean temUti;

    @JsonManagedReference
    @OneToMany (mappedBy = "hospital")
    @JsonView(SwaggerView.NaoEditavel.class)
    private List<Funcionario> funcionarios;

}
