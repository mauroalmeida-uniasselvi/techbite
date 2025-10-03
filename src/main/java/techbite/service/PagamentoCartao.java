
package techbite.service;

import techbite.service.Pagamento;

public class PagamentoCartao implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado com cartão.");
    }
}
