package techbite.service.pedido;

public interface PedidoService {

    java.util.List<techbite.entity.pedido.PedidoEntity> listar();

    void criar(techbite.entity.pedido.PedidoEntity entity) throws Exception;

}
