import { randomUUID } from 'node:crypto';

import { Cliente } from "./cliente";
import { Produto } from "./produto"

export class Pedido {
    produtos: Produto[] = []
    identificacao: string = randomUUID()
    cliente: Cliente

    constructor(cliente: Cliente){
        this.cliente = cliente
        console.log("\n\n\n")
        console.log(`iniciando o pedido ${this.identificacao}...`);
    }

    adicionarProduto(produto: Produto): void {
        console.log(`adicionando ${produto.nome} ao pedido.`);
        this.produtos.push(produto);
    }

    private descontoCliente() {
        return this.cliente.verDesconto();
    }

    listar(): void {
        const desconto = this.descontoCliente();

        if (this.produtos.length === 0) {
            console.log("a listagem de produtos está vazia")
            return
        }

        this.produtos.forEach((produto) => {
            console.log(`${produto.nome}`);
            console.log(`   - R$${produto.preco.toFixed(2)}`);
            if (desconto > 0) {
                const precoComDesconto = produto.preco - produto.preco * desconto;
                console.log(`   - com desconto R$${precoComDesconto.toFixed(2)}`);
            }
        });
    }


    calcularTotal(): number {
        const desconto = this.descontoCliente();
        const total = this.produtos.reduce((acc: number, produto: Produto) => acc + produto.preco, 0);
        const totalComDesconto = total - total * desconto;
        console.log(`Total sem desconto: R$ ${total.toFixed(2)}`);
        console.log(`Total com desconto: R$ ${totalComDesconto.toFixed(2)}`);
        return totalComDesconto;
    }

}
