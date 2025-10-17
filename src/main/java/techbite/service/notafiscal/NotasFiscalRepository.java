package techbite.service.notafiscal;

import techbite.utils.DataFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class NotasFiscalRepository {
    private final techbite.entity.Storage db;

    public NotasFiscalRepository(techbite.entity.Storage db) {
        this.db = db;
    }

    public NotasFiscalRepository() throws IOException {
        this(new techbite.utils.StorageJson());
    }

    public List<techbite.entity.notafiscal.NotaFiscalEntity> findAll() throws IOException {
        List<techbite.entity.notafiscal.NotaFiscalEntity> list = db.listAll(DataFiles.NOTA_FISCAL, techbite.entity.notafiscal.NotaFiscalEntity.class);
        return list == null ? new ArrayList<>() : list;
    }

    // CRUD convenience
    public void create(techbite.entity.notafiscal.NotaFiscalEntity entity) throws IOException {
        db.create(DataFiles.NOTA_FISCAL, techbite.entity.notafiscal.NotaFiscalEntity.class, entity);
    }

    public Optional<techbite.entity.notafiscal.NotaFiscalEntity> getById(String id) throws IOException {
        return db.getById(DataFiles.NOTA_FISCAL, techbite.entity.notafiscal.NotaFiscalEntity.class, id);
    }

    public List<techbite.entity.notafiscal.NotaFiscalEntity> listAll() throws IOException {
        return db.listAll(DataFiles.NOTA_FISCAL, techbite.entity.notafiscal.NotaFiscalEntity.class);
    }

    public techbite.entity.notafiscal.NotaFiscalEntity update(techbite.entity.notafiscal.NotaFiscalEntity entity) throws IOException {
        return db.update(DataFiles.NOTA_FISCAL, techbite.entity.notafiscal.NotaFiscalEntity.class, entity);
    }

    public boolean delete(String id) throws IOException {
        return db.delete(DataFiles.NOTA_FISCAL, techbite.entity.notafiscal.NotaFiscalEntity.class, id);
    }
}
