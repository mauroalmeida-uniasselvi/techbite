package techbite.entity.cliente;

import techbite.utils.*;

import java.io.*;
import java.util.*;

public class ClienteRepository {
    private final techbite.entity.Storage db;

    public ClienteRepository(techbite.entity.Storage db) {
        this.db = db;
    }

    public ClienteRepository() throws IOException {
        this(new techbite.utils.StorageJson());
    }

    public List<ClienteEntity> findAll() throws IOException {
        List<ClienteEntity> list = db.listAll(DataFiles.CLIENTE, ClienteEntity.class);
        return list == null ? new ArrayList<>() : list;
    }

    public void create(ClienteEntity entity) throws IOException {
        db.create(DataFiles.CLIENTE, ClienteEntity.class, entity);
    }

    public Optional<ClienteEntity> getById(String cpf) throws IOException {
        return db.getById(DataFiles.CLIENTE, ClienteEntity.class, cpf);
    }

    public List<ClienteEntity> listAll() throws IOException {
        return db.listAll(DataFiles.CLIENTE, ClienteEntity.class);
    }

    public ClienteEntity update(ClienteEntity entity) throws IOException {
        return db.update(DataFiles.CLIENTE, ClienteEntity.class, entity);
    }

    public boolean delete(String cpf) throws IOException {
        return db.delete(DataFiles.CLIENTE, ClienteEntity.class, cpf);
    }
}
