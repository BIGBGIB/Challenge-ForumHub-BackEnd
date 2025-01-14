package hub.forum.api.domain.topico.validadores.id;

import hub.forum.api.domain.topico.Topico;

import java.util.Optional;

public interface ValidadorID {

    void validar(Optional<Topico> topico);

}
