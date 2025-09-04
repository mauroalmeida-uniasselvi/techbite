// Interface do componente
interface Payment {
  pay(amount: number): void;
}

// Componente concreto
class BasicPayment implements Payment {
  pay(amount: number): void {
    console.log(`Pagamento de R$${amount.toFixed(2)}`);
  }
}

// Decorator base
abstract class PaymentDecorator implements Payment {
  constructor(protected wrappee: Payment) {}

  pay(amount: number): void {
    this.wrappee.pay(amount);
  }
}

// Decorator de promoção: 10% de desconto
class Promo10Decorator extends PaymentDecorator {
  pay(amount: number): void {
    const discounted = amount * 0.9;
    console.log('Aplicando promoção de 10% de desconto');
    super.pay(discounted);
  }
}

// Decorator de promoção: 20% de desconto
class Promo20Decorator extends PaymentDecorator {
  pay(amount: number): void {
    const discounted = amount * 0.8;
    console.log('Aplicando promoção de 20% de desconto');
    super.pay(discounted);
  }
}

// Exemplo de uso
const basic = new BasicPayment();
const promo10 = new Promo10Decorator(basic);
const promo20 = new Promo20Decorator(basic);
const promo10and20 = new Promo20Decorator(promo10);

console.log('--- Sem promoção ---');
basic.pay(100);

console.log('--- Promoção 10% ---');
promo10.pay(100);

console.log('--- Promoção 20% ---');
promo20.pay(100);

console.log('--- Promoção 10% + 20% ---');
promo10and20.pay(100);