package hub.forum.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroTopico(
        @NotBlank //utilizado apenas para string
        String titulo,
        @NotBlank
        String mensagem,
        @NotNull
        String curso,
        @NotNull
        String autor

) {
}
