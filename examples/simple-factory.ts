
interface Pagamento {
  pagar(amount: number): void;
}

// Implementações MercadoLivre e Pagarme
class MercadoLivrePagamento implements Pagamento {
  pagar(amount: number): void {
    console.log(`Pagando R$${amount} via MercadoLivre`);
  }
}

class PagarmePagamento implements Pagamento {
  pagar(amount: number): void {
    console.log(`Pagando R$${amount} via Pagarme`);
  }
}

// Simple Factory
class PagamentoFactory {
  static createPagamento(type: string): Pagamento {
    switch (type) {
      case 'mercadolivre':
        return new MercadoLivrePagamento();
      case 'pagarme':
        return new PagarmePagamento();
      default:
        throw new Error('Tipo de pagamento não suportado');
    }
  }
}

// Exemplo de uso
const Pagamento1 = PagamentoFactory.createPagamento('mercadolivre');
Pagamento1.pagar(100);

const Pagamento2 = PagamentoFactory.createPagamento('pagarme');
Pagamento2.pagar(200);