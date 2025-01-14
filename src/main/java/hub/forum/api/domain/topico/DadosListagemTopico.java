package hub.forum.api.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosListagemTopico( Long id,
                                  String titulo,
                                  String mensagem,
                                  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
                                  LocalDateTime data,
                                  Status status,
                                  String autor,
                                  String curso) {
    public DadosListagemTopico(Topico topico){
        this(topico.getId(),topico.getTitulo(), topico.getMensagem(), topico.getData(),
                topico.getStatus(), topico.getAutor(), topico.getCurso());
    }
}
