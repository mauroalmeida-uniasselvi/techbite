package techbite.service.pagamento;

import techbite.utils.*;

import java.io.*;
import java.util.*;

public class PagamentoRepository {
    private final techbite.entity.Storage db;

    public PagamentoRepository(techbite.entity.Storage db) {
        this.db = db;
    }

    public PagamentoRepository() throws IOException {
        this(new techbite.utils.StorageJson());
    }

    public List<techbite.entity.pagamento.PagamentoEntity> findAll() throws IOException {
        List<techbite.entity.pagamento.PagamentoEntity> list = db.listAll(DataFiles.PAGAMENTO, techbite.entity.pagamento.PagamentoEntity.class);
        return list == null ? new ArrayList<>() : list;
    }


    // CRUD convenience
    public void create(techbite.entity.pagamento.PagamentoEntity entity) throws IOException {
        db.create(DataFiles.PAGAMENTO, techbite.entity.pagamento.PagamentoEntity.class, entity);
    }

    public Optional<techbite.entity.pagamento.PagamentoEntity> getById(String id) throws IOException {
        return db.getById(DataFiles.PAGAMENTO, techbite.entity.pagamento.PagamentoEntity.class, id);
    }

    public List<techbite.entity.pagamento.PagamentoEntity> listAll() throws IOException {
        return db.listAll(DataFiles.PAGAMENTO, techbite.entity.pagamento.PagamentoEntity.class);
    }

    public techbite.entity.pagamento.PagamentoEntity update(techbite.entity.pagamento.PagamentoEntity entity) throws IOException {
        return db.update(DataFiles.PAGAMENTO, techbite.entity.pagamento.PagamentoEntity.class, entity);
    }

    public boolean delete(String id) throws IOException {
        return db.delete(DataFiles.PAGAMENTO, techbite.entity.pagamento.PagamentoEntity.class, id);
    }
}
