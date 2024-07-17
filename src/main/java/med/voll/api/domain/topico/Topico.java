package med.voll.api.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String mensagem;

    @Column(name = "dt_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "estado_topico")
    private String estadoTopico;

    private String autor;
    private String curso;

    // Método para atualizar os dados do tópico
    public void atualizarData(DataAtualizarTopico data) {
        if (data.titulo() != null) {
            this.titulo = data.titulo();
        }
        if (data.mensagem() != null) {
            this.mensagem = data.mensagem();
        }
        if (data.estadoTopico() != null) {
            this.estadoTopico = data.estadoTopico();
        }
        if (data.autor() != null) {
            this.autor = data.autor();
        }
        // Adicione outros campos conforme necessário
    }
}
