package hub.forum.api.domain.topico.validadores.id;

import hub.forum.api.domain.ValidacaoException;
import hub.forum.api.domain.topico.Topico;
import hub.forum.api.domain.topico.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IdValido  implements ValidadorID {

    @Autowired
    private TopicoRepository repository;

    public void validar (Optional<Topico> topico) {

        if (!topico.filter(Topico::getAtivo).isPresent()) {
            throw new ValidacaoException("Id inválido!");
        }
    }
}