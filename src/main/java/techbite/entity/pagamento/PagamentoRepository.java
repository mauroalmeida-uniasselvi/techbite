package techbite.entity.pagamento;

import techbite.entity.*;
import techbite.utils.*;

import java.io.*;
import java.util.*;

public class PagamentosRepository {
    private final Database db;

    public PagamentosRepository(Database db) {
        this.db = db;
    }

    public PagamentosRepository() throws IOException {
        this(new techbite.utils.DatabaseJson());
    }

    public List<PagamentoEntity> findAll() throws IOException {
        List<PagamentoEntity> list = db.listAll(DataFiles.PAGAMENTOS, PagamentoEntity.class);
        return list == null ? new ArrayList<>() : list;
    }


    // CRUD convenience
    public void create(PagamentoEntity entity) throws IOException {
        db.create(DataFiles.PAGAMENTOS, PagamentoEntity.class, entity);
    }

    public Optional<PagamentoEntity> getById(String id) throws IOException {
        return db.getById(DataFiles.PAGAMENTOS, PagamentoEntity.class, id);
    }

    public List<PagamentoEntity> listAll() throws IOException {
        return db.listAll(DataFiles.PAGAMENTOS, PagamentoEntity.class);
    }

    public PagamentoEntity update(PagamentoEntity entity) throws IOException {
        return db.update(DataFiles.PAGAMENTOS, PagamentoEntity.class, entity);
    }

    public boolean delete(String id) throws IOException {
        return db.delete(DataFiles.PAGAMENTOS, PagamentoEntity.class, id);
    }
}
