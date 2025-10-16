
package techbite.service.pagamento;

import techbite.entity.pagamento.TipoPagamento;

public class FabricaSimplesPagamento {
    public static techbite.service.pagamento.Pagamento criarPagamento(TipoPagamento tipo) {
        switch (tipo) {
            case CARTAO:
                return new techbite.service.pagamento.PagamentoCartao();
            case PIX:
                return new techbite.service.pagamento.PagamentoPix();
            default:
                return new techbite.service.pagamento.PagamentoDinheiro();
        }
    }
}
