package techbite.entity.pedido;

import java.time.*;
import java.util.*;

public record PedidoEntity(
        String id,
        String cliente,
        List<String> produtos,
        LocalDateTime criadoEm
) implements techbite.entity.StorageID {

    @Override
    public String getId() {
        return id;
    }
}
