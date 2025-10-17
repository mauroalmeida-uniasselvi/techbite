package techbite.entity.produto;

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

    public List<ProdutoEntity> findAll() throws IOException {
        List<ProdutoEntity> list = json.loadList(ProdutoEntity.class, DataFiles.PRODUTO);
        return list == null ? new ArrayList<>() : list;
    }

    public void saveAll(List<ProdutoEntity> produtos) throws IOException {
        json.saveList(produtos, DataFiles.PRODUTO);
    }
}
