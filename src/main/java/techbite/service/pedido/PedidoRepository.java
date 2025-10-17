package techbite.service.pedido;

import techbite.utils.DataFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoRepository {
    private final techbite.entity.Storage db;

    public PedidoRepository(techbite.entity.Storage db) {
        this.db = db;
    }

    public PedidoRepository() throws IOException {
        this(new techbite.utils.StorageJson());
    }

    public List<techbite.entity.pedido.PedidoEntity> findAll() throws IOException {
        List<techbite.entity.pedido.PedidoEntity> list = db.listAll(DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class);
        return list == null ? new ArrayList<>() : list;
    }

    // CRUD convenience
    public void create(techbite.entity.pedido.PedidoEntity entity) throws IOException {
        db.create(DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class, entity);
    }

    public Optional<techbite.entity.pedido.PedidoEntity> getById(String id) throws IOException {
        return db.getById(DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class, id);
    }

    public List<techbite.entity.pedido.PedidoEntity> listAll() throws IOException {
        return db.listAll(DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class);
    }

    public techbite.entity.pedido.PedidoEntity update(techbite.entity.pedido.PedidoEntity entity) throws IOException {
        return db.update(DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class, entity);
    }

    public boolean delete(String id) throws IOException {
        return db.delete(DataFiles.PEDIDO, techbite.entity.pedido.PedidoEntity.class, id);
    }
}
