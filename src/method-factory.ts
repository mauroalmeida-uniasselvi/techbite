import { Pagamento, PagamentoCartao, PagamentoDinheiro, PagamentoPix } from "./pagamento";


interface MeioPagamento {
    pagamento(): Pagamento
}

class MeioPagamentoCartao implements MeioPagamento {
    pagamento(): Pagamento {
        return new PagamentoCartao();
    }
}

class MeioPagamentoDinheiro implements MeioPagamento {
    pagamento(): Pagamento {
        return new PagamentoDinheiro();
    }
}

class MeioPagamentoPix implements MeioPagamento {
    pagamento(): Pagamento {
        return new PagamentoPix();
    }
}
