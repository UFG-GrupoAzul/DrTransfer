package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Especialidade;
import br.ufg.inf.backend.drtransfer.repository.EspecialidadeRepository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecialidadeService extends GenericService<Especialidade, EspecialidadeRepository> {

    public EspecialidadeService() {
        super("Especialidade");
    }


    @Override
    protected void padronizaCampos(Especialidade entidade) {

    }

    @Override
    protected void validaEntidade(Especialidade entidade) {
        //TODO: nome obrigatorio
        //TODO: descricao Obrigatória
    }


    @Override
    protected void atualizaVinculos(Especialidade entidade) {

    }

    @Override
    protected void atualizarEntidade(Especialidade entidadePersistida, Especialidade entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "nome");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "descricao");
//        entidadePersistida.setNome(entidadeAtualizada.getNome());
//        entidadePersistida.setDescricao(entidadeAtualizada.getDescricao());
    }

}
