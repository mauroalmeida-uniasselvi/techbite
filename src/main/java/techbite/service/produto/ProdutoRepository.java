package techbite.service.produto;

import techbite.utils.DataFiles;
import techbite.utils.JsonFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private final JsonFile json;

    public ProdutoRepository(JsonFile json) {
        this.json = json;
    }

    public ProdutoRepository() throws IOException {
        this(new JsonFile());
    }

    public List<techbite.entity.produto.ProdutoEntity> findAll() throws IOException {
        List<techbite.entity.produto.ProdutoEntity> list = json.loadList(techbite.entity.produto.ProdutoEntity.class, DataFiles.PRODUTO);
        return list == null ? new ArrayList<>() : list;
    }

    public void saveAll(List<techbite.entity.produto.ProdutoEntity> produtos) throws IOException {
        json.saveList(produtos, DataFiles.PRODUTO);
    }
}
