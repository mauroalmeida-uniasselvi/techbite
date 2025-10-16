package techbite.entity.notafiscal;

import techbite.utils.DataFiles;
import techbite.entity.Database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotasFiscalRepository {
    private final Database db;

    public NotasFiscalRepository(Database db) {
        this.db = db;
    }

    public NotasFiscalRepository() throws IOException {
        this(new techbite.utils.DatabaseJson());
    }

    public List<NotaFiscalEntity> findAll() throws IOException {
        List<NotaFiscalEntity> list = db.listAll(DataFiles.NOTA_FISCAL, NotaFiscalEntity.class);
        return list == null ? new ArrayList<>() : list;
    }

    // CRUD convenience
    public void create(NotaFiscalEntity entity) throws IOException {
        db.create(DataFiles.NOTA_FISCAL, NotaFiscalEntity.class, entity);
    }

    public Optional<NotaFiscalEntity> getById(String id) throws IOException {
        return db.getById(DataFiles.NOTA_FISCAL, NotaFiscalEntity.class, id);
    }

    public List<NotaFiscalEntity> listAll() throws IOException {
        return db.listAll(DataFiles.NOTA_FISCAL, NotaFiscalEntity.class);
    }

    public NotaFiscalEntity update(NotaFiscalEntity entity) throws IOException {
        return db.update(DataFiles.NOTA_FISCAL, NotaFiscalEntity.class, entity);
    }

    public boolean delete(String id) throws IOException {
        return db.delete(DataFiles.NOTA_FISCAL, NotaFiscalEntity.class, id);
    }
}
