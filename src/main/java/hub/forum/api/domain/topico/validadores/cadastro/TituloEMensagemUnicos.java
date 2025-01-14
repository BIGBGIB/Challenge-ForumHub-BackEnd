package hub.forum.api.domain.topico.validadores.cadastro;

import hub.forum.api.domain.ValidacaoException;
import hub.forum.api.domain.topico.DadosCadastroTopico;
import hub.forum.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TituloEMensagemUnicos implements ValidadorCadastro {

    @Autowired
    private TopicoRepository repository;

    public void validar (DadosCadastroTopico dados) {

        var topicoExistente = repository.existsByTituloAndMensagemIgnoreCase(dados.titulo(), dados.mensagem());

        if (topicoExistente) {
            throw new ValidacaoException("Título e mensagem existentes");
        }
    }
}
