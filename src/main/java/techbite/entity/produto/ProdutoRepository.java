package techbite.entity.produto;

import techbite.utils.DataFiles;
import techbite.utils.JsonFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosRepository {
    private final JsonFile json;

    public ProdutosRepository(JsonFile json) {
        this.json = json;
    }

    public ProdutosRepository() throws IOException {
        this(new JsonFile());
    }

    public List<Produto> findAll() throws IOException {
        List<Produto> list = json.loadList(Produto.class, DataFiles.PRODUTOS);
        return list == null ? new ArrayList<>() : list;
    }

    public void saveAll(List<Produto> produtos) throws IOException {
        json.saveList(produtos, DataFiles.PRODUTOS);
    }
}
