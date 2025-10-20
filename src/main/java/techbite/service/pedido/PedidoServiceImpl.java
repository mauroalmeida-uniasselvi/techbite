package techbite.service.pedido;

public class PedidoServiceImpl implements PedidoService {

    private final techbite.entity.Storage db;

    public PedidoServiceImpl() {
        try {
            this.db = new techbite.utils.StorageJson();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public java.util.List<techbite.entity.pedido.PedidoEntity> listar() {
        java.util.List<techbite.entity.pedido.PedidoEntity> list;
        try {
            list = db.listAll(techbite.utils.DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class);
        } catch (java.io.IOException e) {
            return new java.util.ArrayList<>();
        }
        return list == null ? new java.util.ArrayList<>() : list;
    }

    @Override
    public void criar(techbite.entity.pedido.PedidoEntity entity) throws Exception {
        db.create(techbite.utils.DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class, entity);
    }
}
