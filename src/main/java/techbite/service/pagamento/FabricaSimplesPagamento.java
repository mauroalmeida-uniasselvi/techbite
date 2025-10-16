
package techbite.service;

import techbite.service.Pagamento;
import techbite.service.PagamentoCartao;
import techbite.service.PagamentoDinheiro;
import techbite.service.PagamentoPix;
import techbite.entity.TipoPagamento;

public class FabricaSimplesPagamento {
    public static Pagamento criarPagamento(TipoPagamento tipo) {
        switch (tipo) {
            case CARTAO:
                return new PagamentoCartao();
            case PIX:
                return new PagamentoPix();
            default:
                return new PagamentoDinheiro();
        }
    }
}
