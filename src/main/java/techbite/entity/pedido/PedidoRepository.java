package techbite.entity.pedido;

import techbite.utils.DataFiles;
import techbite.entity.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidosRepository {
    private final Database db;

    public PedidosRepository(Database db) {
        this.db = db;
    }

    public PedidosRepository() throws IOException {
        this(new techbite.utils.DatabaseJson());
    }

    public List<PedidoEntity> findAll() throws IOException {
        List<PedidoEntity> list = db.listAll(DataFiles.PEDIDOS, PedidoEntity.class);
        return list == null ? new ArrayList<>() : list;
    }

    // CRUD convenience
    public void create(PedidoEntity entity) throws IOException {
        db.create(DataFiles.PEDIDOS, PedidoEntity.class, entity);
    }

    public Optional<PedidoEntity> getById(String id) throws IOException {
        return db.getById(DataFiles.PEDIDOS, PedidoEntity.class, id);
    }

    public List<PedidoEntity> listAll() throws IOException {
        return db.listAll(DataFiles.PEDIDOS, PedidoEntity.class);
    }

    public PedidoEntity update(PedidoEntity entity) throws IOException {
        return db.update(DataFiles.PEDIDOS, PedidoEntity.class, entity);
    }

    public boolean delete(String id) throws IOException {
        return db.delete(DataFiles.PEDIDOS, PedidoEntity.class, id);
    }
}
