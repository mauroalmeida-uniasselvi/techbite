

export interface Pagamento{
    // calcularDesconto(): number;
    pagar(): void;
}

export class PagamentoCartao implements Pagamento {
    pagar(): void {
        console.log("Pagamento realizado com cartão.");
    }
}

export class PagamentoDinheiro implements Pagamento {
    pagar(): void {
        console.log("Pagamento realizado em dinheiro.");
    }
}

export class PagamentoPix implements Pagamento {
    pagar(): void {
        console.log("Pagamento realizado via Pix.");
    }
}   

