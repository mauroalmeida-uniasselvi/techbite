
package techbite.service.pagamento;

public class PagamentoPix implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado via Pix.");
    }
}
