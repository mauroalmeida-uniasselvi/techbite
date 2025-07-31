import { adicionarProduto, Produto, listarPedido, calcularTotal } from "./pedido.fn";

// inicia e cria o pedido
const pedido: Produto[] = [];
console.log("iniciando o pedido...");

const cafe = {
    nome: "Café",
    preco: 5,
};

const refrigerante: Produto = {
    nome: "Refrigerante",
    preco: 4.5,
};
const paoovo = {
    nome: "Pão com Ovo",
    preco: 8.75,
};
const xmonstro = {
    nome: "X-Monstro",
    preco: 12.5,
};

// adiciona produtos ao pedido
adicionarProduto(pedido, refrigerante);
adicionarProduto(pedido, paoovo);
adicionarProduto(pedido, paoovo);

// aplicar desconto
const desconto = 0.1; // 10% de desconto

// listar o pedido
listarPedido(pedido, desconto);


// calcular total do pedido
calcularTotal({ pedido, desconto });
