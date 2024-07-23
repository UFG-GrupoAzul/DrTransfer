package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Especialidade;
import br.ufg.inf.backend.drtransfer.model.Hospital;
import br.ufg.inf.backend.drtransfer.model.Medico;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicoService extends GenericService<Medico, MedicoRepository> {

    @Autowired
    private HospitalService hospitalService;
    private EspecialidadeService especialidadeService;

    public MedicoService() {
        super("Médico");
    }

    @Override
    protected void atualizarEntidade(Medico entidadePersistida, Medico entidadeAtualizada) {

        if (validaString(entidadeAtualizada.getNome())) {
            entidadePersistida.setNome(entidadeAtualizada.getNome());
        }

        if (validaString(entidadeAtualizada.getEmail())) {
            entidadePersistida.setEmail(entidadeAtualizada.getEmail());
        }

        //fazer com as demais.
        entidadePersistida.setTelefone(entidadeAtualizada.getTelefone());

        entidadePersistida.setCpf(entidadeAtualizada.getCpf());

        entidadePersistida.setSexo(entidadeAtualizada.getSexo());

        entidadePersistida.setCrm(entidadeAtualizada.getCrm());

        entidadePersistida.setAtivo(entidadeAtualizada.isAtivo());

        //Buscando o hospital que está vinculado com esse médico para validação.
        Hospital hospitalValidado = hospitalService.findByEntidade(entidadeAtualizada.getHospital());
        if (hospitalValidado != null) {
            entidadePersistida.setHospital(hospitalValidado);
        }

        //Buscando especialidade que está vinculada ao médico para validação.
        Especialidade especialidadeValidada = especialidadeService.findByEntidade(entidadeAtualizada.getEspecialidade());
        if (especialidadeValidada != null) {
            especialidadeService.atualizarEntidade(especialidadeValidada, entidadeAtualizada.getEspecialidade());
            entidadePersistida.setEspecialidade(especialidadeValidada);
        }
    }

    @Override
    protected void validaEntidade(Medico entidade) {

        if (!validaString(entidade.getNome())) {
            throw new DrTransferException(" 'Nome' é obrigatório");
        }
        if (!validaString(entidade.getCrm())) {
            throw new DrTransferException(" 'CRM' é obrigatório");
        }
    }

}
