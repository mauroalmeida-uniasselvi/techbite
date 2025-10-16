package techbite.entity.pedido;

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

    public List<PedidoEntity> findAll() throws IOException {
        List<PedidoEntity> list = db.listAll(DataFiles.PEDIDO, PedidoEntity.class);
        return list == null ? new ArrayList<>() : list;
    }

    // CRUD convenience
    public void create(PedidoEntity entity) throws IOException {
        db.create(DataFiles.PEDIDO, PedidoEntity.class, entity);
    }

    public Optional<PedidoEntity> getById(String id) throws IOException {
        return db.getById(DataFiles.PEDIDO, PedidoEntity.class, id);
    }

    public List<PedidoEntity> listAll() throws IOException {
        return db.listAll(DataFiles.PEDIDO, PedidoEntity.class);
    }

    public PedidoEntity update(PedidoEntity entity) throws IOException {
        return db.update(DataFiles.PEDIDO, PedidoEntity.class, entity);
    }

    public boolean delete(String id) throws IOException {
        return db.delete(DataFiles.PEDIDO, PedidoEntity.class, id);
    }
}
