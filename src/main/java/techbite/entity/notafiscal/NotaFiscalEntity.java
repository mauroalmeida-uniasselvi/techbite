package techbite.entity.notafiscal;

import java.time.LocalDateTime;

public record NotaFiscalEntity(
        String id,
        String pedidoId,
        String numero,
        double valor,
        LocalDateTime criadoEm
) implements techbite.entity.StorageID {
    @Override
    public String getId() { return id; }
}
