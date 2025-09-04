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

// Creator (Fábrica)
abstract class PaymentCreator {
  abstract createPayment(): Payment;

  process(amount: number) {
    const payment = this.createPayment();
    payment.pay(amount);
  }
}

// Fábricas concretas
class MercadoLivrePaymentCreator extends PaymentCreator {
  createPayment(): Payment {
    return new MercadoLivrePayment();
  }
}

class PagarmePaymentCreator extends PaymentCreator {
  createPayment(): Payment {
    return new PagarmePayment();
  }
}

// Exemplo de uso
const mlCreator = new MercadoLivrePaymentCreator();
const pagarmeCreator = new PagarmePaymentCreator();

console.log('--- MercadoLivre ---');
mlCreator.process(100);

console.log('--- Pagarme ---');
pagarmeCreator.process(200);