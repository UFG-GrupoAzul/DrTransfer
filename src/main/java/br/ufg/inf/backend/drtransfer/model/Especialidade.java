package br.ufg.inf.backend.drtransfer.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Especialidade extends SuperClass {
    private String nome;
    private String descricao;
}
