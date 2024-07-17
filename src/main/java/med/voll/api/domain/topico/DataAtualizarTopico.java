package med.voll.api.domain.topico;

import jakarta.validation.constraints.NotNull;

public record DataAtualizarTopico(
        @NotNull Integer id,
        String titulo,
        String mensagem,
        String estadoTopico,
        String autor
) {
    public DataAtualizarTopico {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
    }
}