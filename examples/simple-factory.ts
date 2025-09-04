// Produto
interface Payment {
  pay(amount: number): void;
}

// Implementações MercadoLivre e Pagarme
class MercadoLivrePayment implements Payment {
  pay(amount: number): void {
    console.log(`Pagando R$${amount} via MercadoLivre`);
  }
}

class PagarmePayment implements Payment {
  pay(amount: number): void {
    console.log(`Pagando R$${amount} via Pagarme`);
  }
}

// Simple Factory
class PaymentFactory {
  static createPayment(type: string): Payment {
    switch (type) {
      case 'mercadolivre':
        return new MercadoLivrePayment();
      case 'pagarme':
        return new PagarmePayment();
      default:
        throw new Error('Tipo de pagamento não suportado');
    }
  }
}

// Exemplo de uso
const payment1 = PaymentFactory.createPayment('mercadolivre');
payment1.pay(100);

const payment2 = PaymentFactory.createPayment('pagarme');
payment2.pay(200);