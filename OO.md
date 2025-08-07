
# 📘 Documentação de Programação Orientada a Objetos (POO)

## ✅ O que é Programação Orientada a Objetos?

A **Programação Orientada a Objetos (POO)** é um paradigma de programação baseado no conceito de “objetos”, que são instâncias de **classes** e representam entidades do mundo real. Cada objeto possui **atributos** (dados) e **métodos** (comportamentos).

### 🧩 Princípios Fundamentais da POO

1. Encapsulamento
2. Herança
3. Polimorfismo


---

## 1. 🔒 Encapsulamento

### Definição

O **encapsulamento** oculta os dados internos de uma classe, expondo apenas o necessário por meio de métodos públicos. Isso protege os dados de acessos e modificações indevidas.

### Exemplo (TypeScript)

```ts
class BankAccount {
  private balance: number;

  constructor(initialBalance: number) {
    this.balance = initialBalance;
  }

  deposit(amount: number): void {
    if (amount > 0) {
      this.balance += amount;
    }
  }

  getBalance(): number {
    return this.balance;
  }
}

const account = new BankAccount(1000);
account.deposit(500);
console.log(account.getBalance()); // 1500
// account.balance = 10000; // Erro: propriedade privada
```

---

## 2. 🧬 Herança

### Definição

A **herança** permite que uma classe herde atributos e comportamentos de outra. A classe que herda é chamada de **subclasse** e a que é herdada é chamada de **superclasse**.

### Exemplo (TypeScript)

```ts
class Person {
  constructor(public name: string) {}

  greet(): void {
    console.log(`Hello, my name is ${this.name}`);
  }
}

class Student extends Person {
  constructor(name: string, public studentId: number) {
    super(name); // chama o construtor da superclasse
  }

  study(): void {
    console.log(`${this.name} is studying`);
  }
}

const student = new Student("Alice", 123);
student.greet(); // Hello, my name is Alice
student.study(); // Alice is studying
```

---

## 3. 🎭 Polimorfismo

### Definição

**Polimorfismo** permite que diferentes classes respondam de maneira diferente a uma mesma chamada de método. Pode ocorrer por **sobrescrita (override)** ou **sobrecarga (overload)**.

### Exemplo - Sobrescrita (Override)

```ts
class Shape {
  draw(): void {
    console.log("Drawing a shape");
  }
}

class Circle extends Shape {
  draw(): void {
    console.log("Drawing a circle");
  }
}

class Square extends Shape {
  draw(): void {
    console.log("Drawing a square");
  }
}

const shapes: Shape[] = [new Circle(), new Square()];
shapes.forEach(shape => shape.draw());
/*
  Drawing a circle
  Drawing a square
*/
```

---

## 📌 Conclusão

A Programação Orientada a Objetos é um dos paradigmas mais utilizados no desenvolvimento moderno, pois permite:

- Modelar o mundo real de forma intuitiva
- Reutilizar código com herança
- Modularizar e esconder detalhes internos com encapsulamento
- Extender funcionalidades com polimorfismo
- Criar sistemas mais organizados e manuteníveis

---

