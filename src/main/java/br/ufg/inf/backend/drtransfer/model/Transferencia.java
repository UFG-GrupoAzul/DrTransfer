package br.ufg.inf.backend.drtransfer.model;

import br.ufg.inf.backend.drtransfer.enumeradores.MeioTransporte;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClassAtivo;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia extends SuperClassAtivo {
    @Enumerated(EnumType.STRING)
    private MeioTransporte meioTransporte;


    private LocalDateTime horarioSaida;
    private LocalDateTime horarioPrevistoChegada;

    private Double distancia;
//
//    private Paciente paciente;
//    private Medico medicoOrigem;
//    private Hospital hospitalOrigem;
//    private Medico medicoDestino;
//    private Hospital hospitalDestino;
//
//    private MedicoRegulador medicoRegulador;
//
//    private DocumentoTransferencia documento;
//    private Solicitacao solicitacao;

}
