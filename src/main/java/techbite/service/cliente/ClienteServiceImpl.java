package techbite.service.cliente;

public class ClienteServiceImpl implements techbite.service.cliente.ClienteService {

    private final techbite.entity.Storage db;

    public ClienteServiceImpl() {
        try {
            this.db = new techbite.utils.StorageJson();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public java.util.List<techbite.entity.cliente.ClienteEntity> listar() {
        java.util.List<techbite.entity.cliente.ClienteEntity> list;
        try {
            list = db.listAll(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class);
        } catch (java.io.IOException e) {
            return new java.util.ArrayList<>();
        }
        return list == null ? new java.util.ArrayList<>() : list;
    }

    @Override
    public techbite.entity.cliente.ClienteEntity obterPorId(String id) {
        try {
            return db.getById(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class, id).orElse(null);
        } catch (java.io.IOException e) {
            return null;
        }
    }

    @Override
    public void criar(techbite.entity.cliente.ClienteEntity entity) throws Exception {
        db.create(techbite.utils.DataFiles.CLIENTE, techbite.entity.cliente.ClienteEntity.class, entity);
    }

}
