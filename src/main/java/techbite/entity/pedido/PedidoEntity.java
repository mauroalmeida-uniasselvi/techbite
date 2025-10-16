package techbite.entity.pedido;

import techbite.entity.*;

import java.time.*;
import java.util.*;

public record PedidoEntity(
        String id,
        String cliente,
        List<String> produtos,
        double total,
        boolean pago,
        LocalDateTime criadoEm
) implements Identifiable {
    @Override
    public String getId() {
        return id;
    }
}
