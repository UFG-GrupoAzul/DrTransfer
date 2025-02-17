package br.ufg.inf.backend.drtransfer.controller;

import br.ufg.inf.backend.drtransfer.model.Medico;
import br.ufg.inf.backend.drtransfer.service.MedicoService;
import br.ufg.inf.backend.drtransfer.utils.GenericControllerWithDeletion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController extends GenericControllerWithDeletion<Medico, MedicoService> {
}
