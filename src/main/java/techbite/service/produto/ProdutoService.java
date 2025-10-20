package techbite.service.produto;

public interface ProdutoService {

    java.util.List<techbite.entity.produto.ProdutoEntity> listar();

    void criar(techbite.entity.produto.ProdutoEntity entity) throws Exception;


}
