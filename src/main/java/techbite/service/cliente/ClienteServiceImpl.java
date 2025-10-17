package techbite.service.cliente;

public class ClienteServiceImpl implements techbite.service.IClienteService {

    private final techbite.entity.Storage db;

    public ClienteServiceImpl() {
        try {
            this.db = new techbite.utils.StorageJson();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public java.util.List<techbite.entity.cliente.ClienteEntity> listarClientes() throws java.io.IOException {
        java.util.List<techbite.entity.cliente.ClienteEntity> list =
                db.listAll(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class);
        return list == null ? new java.util.ArrayList<>() : list;
    }

    @Override
    public void criar(techbite.entity.cliente.ClienteEntity entity) throws java.io.IOException {
        db.create(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class, entity);
    }

    @Override
    public java.util.Optional<techbite.entity.cliente.ClienteEntity> buscarPorId(String cpf) throws java.io.IOException {
        return db.getById(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class, cpf);
    }

    @Override
    public techbite.entity.cliente.ClienteEntity atualizar(techbite.entity.cliente.ClienteEntity entity) throws java.io.IOException {
        return db.update(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class, entity);
    }

    @Override
    public boolean remover(String cpf) throws java.io.IOException {
        return db.delete(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class, cpf);
    }


}
