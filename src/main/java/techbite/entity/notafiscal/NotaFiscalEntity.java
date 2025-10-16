package techbite.entity.notafiscal;

import techbite.entity.Identifiable;
import java.time.LocalDateTime;

public record NotaFiscalEntity(
        String id,
        String pedidoId,
        String numero,
        double valor,
        LocalDateTime criadoEm
) implements Identifiable {
    @Override
    public String getId() { return id; }
}
