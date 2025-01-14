package hub.forum.api.domain.topico;

import hub.forum.api.domain.topico.validadores.atualizacao.ValidadorAtuliazacao;
import hub.forum.api.domain.topico.validadores.cadastro.ValidadorCadastro;
import hub.forum.api.domain.topico.validadores.id.ValidadorID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDeTopicos {

    @Autowired
    private TopicoRepository repository;

    @Autowired
    private List<ValidadorCadastro> validadoresDeCadastro;

    @Autowired
    private List<ValidadorID> validadoresDeId;

    @Autowired
    private  List<ValidadorAtuliazacao> validadoresDeAtualização;

    public DadosDetalhamentoTopico cadastrar (DadosCadastroTopico dados) {

        validadoresDeCadastro.forEach(v -> v.validar(dados));

        var topico = new Topico(dados);
        repository.save(topico);

        return new DadosDetalhamentoTopico(topico);
    }

    public DadosListagemTopico listarPorId (Long id) {

        var idValido = repository.findById(id);

        validadoresDeId.forEach(v -> v.validar(idValido));

        Topico topicoValido = idValido.get();

        return new DadosListagemTopico(topicoValido);
    }

    public DadosAtualizarTopico atualizar (Long id, DadosAtualizarTopico dados) {

        var idValido = repository.findById(id);

        validadoresDeId.forEach(v -> v.validar(idValido));

        validadoresDeAtualização.forEach((v -> v.validar(dados)));

        Topico topicoValido = idValido.get();

        topicoValido.atualizarInformacoes(dados);

        return new DadosAtualizarTopico(topicoValido);
    }

    public Topico verificarId (Long id) {

        var idValido = repository.findById(id);

        validadoresDeId.forEach(v -> v.validar(idValido));

        Topico topicoValido = idValido.get();

        return topicoValido;
    }
}
