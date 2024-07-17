package med.voll.api.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataCadastroTopico(
        @NotNull Integer id,
        @NotBlank String titulo,
        String mensagem,
        @NotNull LocalDateTime dtCriacao,
        @NotBlank String estadoTopico,
        @NotBlank String autor,
        String curso
) {
    public DataCadastroTopico {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("titulo cannot be null or blank");
        }
        if (dtCriacao == null) {
            throw new IllegalArgumentException("dtCriacao cannot be null");
        }
        if (estadoTopico == null || estadoTopico.isBlank()) {
            throw new IllegalArgumentException("estadoTopico cannot be null or blank");
        }
        if (autor == null || autor.isBlank()) {
            throw new IllegalArgumentException("autor cannot be null or blank");
        }
    }
}
