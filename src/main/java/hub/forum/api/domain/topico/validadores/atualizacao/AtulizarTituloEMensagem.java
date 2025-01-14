package hub.forum.api.domain.topico.validadores.atualizacao;

import hub.forum.api.domain.ValidacaoException;
import hub.forum.api.domain.topico.DadosAtualizarTopico;
import hub.forum.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtulizarTituloEMensagem implements ValidadorAtuliazacao {

    @Autowired
    private TopicoRepository repository;

    public void validar (DadosAtualizarTopico dados) {

        var topicoExistente = repository.existsByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if (topicoExistente) {
            throw new ValidacaoException("Título e mensagem existentes");
        }
    }
}
