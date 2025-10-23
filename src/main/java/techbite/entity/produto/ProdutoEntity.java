package techbite.entity.produto;

public record ProdutoEntity(
        String id,
        String nome,
        String descricao,
        double preco
) implements techbite.entity.StorageID {

    @Override
    public String getId() {
        return id;
    }
}

