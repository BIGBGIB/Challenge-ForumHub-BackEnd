package hub.forum.api.domain.topico;

public record DadosAtualizarTopico(String titulo, String mensagem, String curso) {

    public DadosAtualizarTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensagem(), topico.getCurso());
    }
}
