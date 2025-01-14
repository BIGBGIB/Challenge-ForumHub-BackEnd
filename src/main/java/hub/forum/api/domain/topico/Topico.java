package hub.forum.api.domain.topico;

import com.fasterxml.jackson.annotation.JsonFormat;
import hub.forum.api.domain.user.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensagem;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime data = LocalDateTime.now();
    private String curso;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String autor;

    public Topico(DadosCadastroTopico dados) {
        this.status = Status.ESPERANDO_RESPOSTA;
        this.data = LocalDateTime.now();
        this.mensagem = dados.mensagem();
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.curso = dados.curso();
        this.ativo = true;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void atualizarInformacoes(DadosAtualizarTopico dados) {
        if(dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if(dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if(dados.curso() != null) {
            this.curso = dados.curso();
        }
    }

    public void excluir() {
        this.ativo = false;
    }

}


