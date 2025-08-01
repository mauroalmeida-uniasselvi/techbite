

export class Produto {
    nome: string;
    preco: number;

    constructor(nome: string, preco: number) {
        this.nome = nome
        this.preco = preco
    }
}

export class Pedido {
    produtos: Produto[] = []
    desconto: number = 0
    identificacao: string;

    constructor(identificacao: string){
        this.identificacao = identificacao
        console.log("\n\n\n")
        console.log(`iniciando o pedido ${identificacao}..`);
    }

    adicionarProduto(produto: Produto): void {
        console.log(`adicionando ${produto.nome} ao pedido.`);
        this.produtos.push(produto);
    }

    alterarDesconto(desconto: number) {
        this.desconto = desconto
    }

    listar(): void {

        if (this.produtos.length === 0) {
            console.log("a listagem de produtos está vazia")
            return
        }

        this.produtos.forEach((produto) => {
            console.log(`${produto.nome}`);
            console.log(`   - R$${produto.preco.toFixed(2)}`);
            if (this.desconto > 0) {
                const precoComDesconto = produto.preco - produto.preco * this.desconto;
                console.log(`   - com desconto R$${precoComDesconto.toFixed(2)}`);
            }
        });
    }


    calcularTotal(): number {
        const total = this.produtos.reduce((acc: number, produto: Produto) => acc + produto.preco, 0);
        const totalComDesconto = total - total * this.desconto;
        console.log(`Total sem desconto: R$ ${total.toFixed(2)}`);
        console.log(`Total com desconto: R$ ${totalComDesconto.toFixed(2)}`);
        return totalComDesconto;
    }

}
