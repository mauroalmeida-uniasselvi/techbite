package techbite.entity.cliente;

import techbite.entity.*;
import techbite.utils.*;

import java.io.*;
import java.util.*;

public class ClientesRepository {
    private final Database db;

    public ClientesRepository(Database db) {
        this.db = db;
    }

    public ClientesRepository() throws IOException {
        this(new techbite.utils.DatabaseJson());
    }

    public List<ClientePersistEntity> findAll() throws IOException {
        List<ClientePersistEntity> list = db.listAll(DataFiles.CLIENTES, ClientePersistEntity.class);
        return list == null ? new ArrayList<>() : list;
    }

    // CRUD convenience
    public void create(ClientePersistEntity entity) throws IOException {
        db.create(DataFiles.CLIENTES, ClientePersistEntity.class, entity);
    }

    public Optional<ClientePersistEntity> getById(String cpf) throws IOException {
        return db.getById(DataFiles.CLIENTES, ClientePersistEntity.class, cpf);
    }

    public List<ClientePersistEntity> listAll() throws IOException {
        return db.listAll(DataFiles.CLIENTES, ClientePersistEntity.class);
    }

    public ClientePersistEntity update(ClientePersistEntity entity) throws IOException {
        return db.update(DataFiles.CLIENTES, ClientePersistEntity.class, entity);
    }

    public boolean delete(String cpf) throws IOException {
        return db.delete(DataFiles.CLIENTES, ClientePersistEntity.class, cpf);
    }
}
