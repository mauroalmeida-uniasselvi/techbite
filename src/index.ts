// import { adicionarProduto, Produto, listarPedido, calcularTotal } from "./pedido.fn";

import { Pedido, Produto  } from "./pedido.oo"

const cafe =  new Produto("Café", 5);
const refrigerante: Produto = new Produto("Refrigerante", 4.5)
const paoovo = new Produto("Pão com Ovo", 8.75)
const xmonstro = new Produto("X-Monstro", 12.5)

// PEDIDO 1

const pedido1: Pedido = new Pedido("pedido1")
pedido1.adicionarProduto(xmonstro)
pedido1.adicionarProduto(refrigerante)
pedido1.listar()
pedido1.calcularTotal()
console.log("\n")
pedido1.alterarDesconto(0.1)
pedido1.listar()
pedido1.calcularTotal()




const pedido2: Pedido = new Pedido("pedido2")
pedido2.alterarDesconto(0.1)
pedido2.adicionarProduto(cafe)
pedido2.adicionarProduto(paoovo)
pedido2.listar()
pedido2.calcularTotal()

// inicia e cria o pedido
// const pedido1: Produto[] = [];
// console.log("iniciando o pedido1...");
// // adiciona produtos ao pedido
// adicionarProduto(pedido1, refrigerante);
// adicionarProduto(pedido1, paoovo);
// adicionarProduto(pedido1, paoovo);
// // aplicar desconto
// const desconto1 = 0.1; // 10% de desconto
// // listar o pedido
// listarPedido(pedido1, desconto1);
// // calcular total do pedido
// calcularTotal({ pedido: pedido1, desconto: desconto1 });


// inicia e cria o pedido
// const pedido2: Produto[] = [];
// console.log("iniciando o pedido2...");
// // adiciona produtos ao pedido
// adicionarProduto(pedido2, refrigerante);
// adicionarProduto(pedido2, paoovo);
// adicionarProduto(pedido2, paoovo);
// // aplicar desconto
// const desconto2 = 0.2; // 20% de desconto
// // listar o pedido
// listarPedido(pedido2, desconto2);
// // calcular total do pedido
// calcularTotal({ pedido: pedido2, desconto: desconto2 });



