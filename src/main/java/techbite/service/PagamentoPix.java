
package techbite.service;

import techbite.service.Pagamento;

public class PagamentoPix implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado via Pix.");
    }
}
