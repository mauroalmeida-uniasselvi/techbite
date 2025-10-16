package techbite.entity.pagamento;

import techbite.entity.*;

import java.time.*;

public record PagamentoEntity(
        String id,
        String pedido,
        TipoPagamento tipo,
        java.math.BigDecimal valor,
        String status,
        LocalDateTime criadoEm
) implements Identifiable {
    @Override
    public String getId() {
        return id;
    }
}
