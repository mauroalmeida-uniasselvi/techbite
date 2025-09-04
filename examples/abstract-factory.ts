// Interfaces dos produtos
interface Payment {
  pay(amount: number): void;
}

interface Refund {
  refund(amount: number): void;
}

// Interfaces da fábrica abstrata
interface PaymentFactory {
  createPayment(): Payment;
  createRefund(): Refund;
}

// Implementações MercadoLivre
class MercadoLivrePayment implements Payment {
  pay(amount: number): void {
    console.log(`Pagando R$${amount} via MercadoLivre`);
  }
}

class MercadoLivreRefund implements Refund {
  refund(amount: number): void {
    console.log(`Estornando R$${amount} via MercadoLivre`);
  }
}

class MercadoLivreFactory implements PaymentFactory {
  createPayment(): Payment {
    return new MercadoLivrePayment();
  }
  createRefund(): Refund {
    return new MercadoLivreRefund();
  }
}

// Implementações Pagarme
class PagarmePayment implements Payment {
  pay(amount: number): void {
    console.log(`Pagando R$${amount} via Pagarme`);
  }
}

class PagarmeRefund implements Refund {
  refund(amount: number): void {
    console.log(`Estornando R$${amount} via Pagarme`);
  }
}

class PagarmeFactory implements PaymentFactory {
  createPayment(): Payment {
    return new PagarmePayment();
  }
  createRefund(): Refund {
    return new PagarmeRefund();
  }
}

// Cliente
function processOrder(factory: PaymentFactory, amount: number) {
  const payment = factory.createPayment();
  const refund = factory.createRefund();

  payment.pay(amount);
  refund.refund(amount / 2);
}

// Exemplo de uso
const mlFactory = new MercadoLivreFactory();
const pagarmeFactory = new PagarmeFactory();

console.log('--- MercadoLivre ---');
processOrder(mlFactory, 100);

console.log('--- Pagarme ---');
processOrder(pagarmeFactory, 200);