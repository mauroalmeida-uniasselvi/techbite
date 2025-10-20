package techbite.service.produto;

public class ProdutoServiceImpl implements techbite.service.produto.ProdutoService {

    private final techbite.entity.Storage db;

    public ProdutoServiceImpl() {
        try {
            this.db = new techbite.utils.StorageJson();
        } catch (java.io.IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public java.util.List<techbite.entity.produto.ProdutoEntity> listar() {
        java.util.List<techbite.entity.produto.ProdutoEntity> list;
        try {
            list = db.listAll(techbite.utils.DataFiles.PRODUTO, techbite.entity.produto.ProdutoEntity.class);
        } catch (java.io.IOException e) {
            return new java.util.ArrayList<>();
        }
        return list == null ? new java.util.ArrayList<>() : list;
    }

    @Override
    public void criar(techbite.entity.produto.ProdutoEntity entity) throws Exception {
        db.create(techbite.utils.DataFiles.PRODUTO, techbite.entity.produto.ProdutoEntity.class, entity);
    }
}
