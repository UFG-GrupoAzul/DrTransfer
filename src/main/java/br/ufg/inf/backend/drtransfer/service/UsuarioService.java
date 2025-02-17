package br.ufg.inf.backend.drtransfer.service;

import br.ufg.inf.backend.drtransfer.exception.DrTransferException;
import br.ufg.inf.backend.drtransfer.model.Usuario;
import br.ufg.inf.backend.drtransfer.repository.UsuarioRespository;
import br.ufg.inf.backend.drtransfer.utils.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericService<Usuario, UsuarioRespository> {

    public UsuarioService() {
        super("Usuário");
    }

    @Override
    protected void padronizaCampos(Usuario entidade) {
        senhaCriptografada(entidade);
    }

    @Override
    protected void validaEntidade(Usuario entidade) throws DrTransferException {
        validaLogin(entidade);
        validaSenha(entidade);
    }
    private void validaLogin(Usuario entidade) throws DrTransferException {
        campoObrigatorio(entidade.getLogin(), "Login");
        if ((entidade.isNovo() && repository.existsByLogin(entidade.getLogin()))
                || (!entidade.isNovo() && repository.existsByLoginAndIdNot(entidade.getLogin(), entidade.getId()))) {
            throw new DrTransferException(HttpStatus.CONFLICT, CONFLICT, nomeClasse, "Login");
        }
    }

    private void validaSenha(Usuario entidade) throws DrTransferException {
        if (entidade.isNovo()) {
            campoObrigatorio(entidade.getSenha(), "Senha");
        }
        //Valida total caracteres minimo
        if(entidade.getSenha().length() <= 6){
            throw new DrTransferException(HttpStatus.BAD_REQUEST,"Senha deve ter no mínimo 6 caracteres");
        }
        //Valida regex para senha
    }

    @Override
    protected void atualizarEntidade(Usuario entidadePersistida, Usuario entidadeAtualizada) throws DrTransferException {
        atualizaCampo(entidadePersistida, entidadeAtualizada, "login");
        atualizaCampo(entidadePersistida, entidadeAtualizada, "senha");
    }

    @Override
    protected void atualizaVinculos(Usuario entidade) {

    }

    private void senhaCriptografada(Usuario entidade) {
        if (entidade.getSenha() != null) {
            String senhaCriptografada = entidade.getSenha();
            //TODO: gerar uma forma de criptografar a senha.
            senhaCriptografada = senhaCriptografada.concat("criptografado");
            entidade.setSenha(senhaCriptografada);
        }
    }

}
