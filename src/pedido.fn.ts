export type Produto = {
  nome: string;
  preco: number;
};


export function adicionarProduto(pedido: Produto[], produto: Produto): void {
  console.log(`adicionando ${produto.nome} ao pedido.`);
  pedido.push(produto);
}

export function listarPedido(pedido: Produto[], desconto = 0): void {
  pedido.forEach((produto) => {
    console.log(`${produto.nome}`);
    console.log(`   - R$${produto.preco.toFixed(2)}`);
    if(desconto > 0) {
      const precoComDesconto = produto.preco - produto.preco * desconto;
      console.log(`   - com desconto R$${precoComDesconto.toFixed(2)}`);
    }
  });
}

export function calcularTotal({ pedido, desconto = 0 }: { pedido: Produto[]; desconto?: number; }): number {
  const total = pedido.reduce((acc, produto) => acc + produto.preco, 0);
  const totalComDesconto = total - total * desconto;
  console.log(`Total sem desconto: R$ ${total.toFixed(2)}`);
  console.log(`Total com desconto: R$ ${totalComDesconto.toFixed(2)}`);
  return totalComDesconto;
}

