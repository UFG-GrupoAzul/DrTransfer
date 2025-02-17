package br.ufg.inf.backend.drtransfer.utils;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.abstracts.SuperClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class GenericController<E extends SuperClass, S extends GenericService<E, ? extends JpaRepository<E, Long>>> {

    @Autowired
    protected S service;

    @GetMapping(produces = "application/json")
    public ResponseEntity<?> getAll() {
        try {
            List<E> entidades = service.findAll();
            if (entidades.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(entidades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Falha ao buscar: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody E entidade) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(entidade));
        } catch (DrTransferException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Falha ao salvar: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody E entidade) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.update(id, entidade));
        } catch (DrTransferException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Falha ao atualizar: " + e.getMessage());
        }
    }



}
