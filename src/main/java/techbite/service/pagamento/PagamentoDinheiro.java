
package techbite.service.pagamento;

public class PagamentoDinheiro implements Pagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento realizado em dinheiro.");
    }
}
