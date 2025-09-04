
// Classe abstrata com o método template
abstract class PaymentProcessor {
  // Método template
  process(amount: number): void {
    this.validate(amount);
    this.connect();
    this.pay(amount);
    this.disconnect();
  }

  protected validate(amount: number): void {
    if (amount <= 0) {
      throw new Error('Valor inválido para pagamento');
    }
  }

  protected connect(): void {
    console.log('Conectando ao serviço de pagamento...');
  }

  protected disconnect(): void {
    console.log('Desconectando do serviço de pagamento...');
  }

  // Método abstrato a ser implementado pelas subclasses
  protected abstract pay(amount: number): void;
}

// Implementação MercadoLivre
class MercadoLivreProcessor extends PaymentProcessor {
  protected pay(amount: number): void {
    console.log(`Pagando R$${amount} via MercadoLivre`);
  }
}

// Implementação Pagarme
class PagarmeProcessor extends PaymentProcessor {
  protected pay(amount: number): void {
    console.log(`Pagando R$${amount} via Pagarme`);
  }
}

// Exemplo de uso
const ml = new MercadoLivreProcessor();
const pagarme = new PagarmeProcessor();

console.log('--- MercadoLivre ---');
ml.process(100);

console.log('--- Pagarme ---');
pagarme.process(200);