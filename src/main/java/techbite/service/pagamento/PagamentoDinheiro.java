
package techbite.service;

import techbite.service.Pagamento;

public class PagamentoDinheiro implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado em dinheiro.");
    }
}
