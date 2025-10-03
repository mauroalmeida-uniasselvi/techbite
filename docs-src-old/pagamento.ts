

export enum TipoPagamento { CARTAO, DINHEIRO, PIX }


export interface Pagamento {
    // calcularDesconto(): number;
    pagar(valor: number): void;
}

export interface NotaFiscal {
    emitir(): void;
}


export class FabricaSimplesPagamento {
    static criarPagamento(tipo: TipoPagamento): Pagamento {
        switch (tipo) {
            case TipoPagamento.CARTAO:
                return new PagamentoCartao();
            case TipoPagamento.PIX:
                return new PagamentoPix();
            default:
                return new PagamentoDinheiro();
        }
    }
}

export class PagamentoCartao implements Pagamento {
    pagar(valor: number): void {
        console.log("Pagamento realizado com cartão.");
    }
}

export class PagamentoDinheiro implements Pagamento {
    pagar(valor: number): void {
        console.log("Pagamento realizado em dinheiro.");
    }
}

export class PagamentoPix implements Pagamento {
    pagar(valor: number): void {
        console.log("Pagamento realizado via Pix.");
    }
}

