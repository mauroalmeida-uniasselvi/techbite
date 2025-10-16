package techbite.entity.pagamento;

import java.time.*;

public record PagamentoEntity(
        String id,
        String pedido,
        TipoPagamento tipo,
        java.math.BigDecimal valor,
        String status,
        LocalDateTime criadoEm
) implements techbite.entity.StorageID {
    @Override
    public String getId() {
        return id;
    }
}
