package techbite.service.pedido;

public class PedidoFacade {

    private final techbite.service.pedido.PedidoService pedidoService;
    private final techbite.service.produto.ProdutoService produtoService;
    private final techbite.service.cliente.ClienteService clienteService;

    public PedidoFacade(techbite.service.pedido.PedidoService pedidoService, techbite.service.produto.ProdutoService produtoService, techbite.service.cliente.ClienteService clienteService) {
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;
        this.clienteService = clienteService;
    }

    public techbite.entity.cliente.Cliente obterClientePorId(String id) {
        techbite.entity.cliente.ClienteEntity clienteEntity = this.clienteService.obterPorId(id);
        return techbite.entity.cliente.ClienteFactory.builder().cliente(clienteEntity).build();
    }

    public techbite.entity.produto.Produto obterProdutoPorId(String id) {
        techbite.entity.produto.ProdutoEntity produtoEntity = this.produtoService.obterPorId(id);
        if (produtoEntity != null) {
            return new techbite.entity.produto.Produto(produtoEntity);
        }
        return null;
    }

    public java.util.List<techbite.entity.pedido.Pedido> listarPedidos() {
        java.util.List<techbite.entity.pedido.Pedido> pedidos = new java.util.ArrayList<>();
        java.util.List<techbite.entity.pedido.PedidoEntity> pedidosEntity = this.pedidoService.listar();
        for (techbite.entity.pedido.PedidoEntity pedidoEntity : pedidosEntity) {
            techbite.entity.cliente.Cliente cliente = this.obterClientePorId(pedidoEntity.cliente());
            techbite.entity.pedido.Pedido pedido = new techbite.entity.pedido.Pedido(cliente, pedidoEntity.criadoEm());
            for (String produtoId : pedidoEntity.produtos()) {
                techbite.entity.produto.Produto produto = this.obterProdutoPorId(produtoId);
                if (produto != null) {
                    pedido.adicionarProduto(produto);
                }
            }
            pedidos.add(pedido);
        }
        return pedidos;
    }

}
