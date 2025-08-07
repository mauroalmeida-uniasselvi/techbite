# 📘 Programação Orientada a Objetos (POO) - Resumo

## O que é POO?

Paradigma baseado em **objetos** (instâncias de classes) que possuem **atributos** e **métodos**.

## Princípios Fundamentais

---

### 1. Encapsulamento

Oculta dados internos da classe, expondo apenas o necessário.

O modificadores dos atributos podem ser publicos (public), privados (private) e protegidos (protected)

```ts
class Transacao {
  operacao: string; // debito | credito
  valor: number
  data: number
}

class Conta {
  private saldo: number;
  constructor(s: number) { this.saldo = s; }
  depositar(v: number) { if (v > 0) this.saldo += v; }
  verSaldo() { return this.saldo; }
}
class ContaCorrente extends Conta {
  private transacoes: Transacao[]
  verTransacoes() {
   // ...
   console.log("O saldo total eh") 
 }
}
```

---

### 2. Herança

Permite que uma classe herde atributos e métodos de outra.  
A classe que herda é chamada de **subclasse** e a que é herdada é chamada de **superclasse**.

```ts
class Pessoa { constructor(public nome: string) {} }
class Aluno extends Pessoa { constructor(nome: string, public id: number) { super(nome); } }
```

#### "É um" vs "Tem um"

- **Herança** representa uma relação "**é um**" (ex: Aluno **é um** Pessoa).
- **Composição** representa uma relação "**tem um**" (ex: Carro **tem um** Motor).

Exemplo de composição:

```ts
class Motor {}
class Carro {
  motor: Motor;
  constructor() { this.motor = new Motor(); }
}
```

--- 

### 3. Polimorfismo

Permite que métodos com o mesmo nome tenham comportamentos diferentes, por sobrescrita (override) ou sobrecarga (overload).

```ts
class Forma {
  desenhar() {
    console.log("Forma");
  }
}
class Circulo extends Forma {
  desenhar() {
    console.log("Círculo");
  }
}
```

Outro exemplo:

```ts
class Shape {
  draw(): void { console.log("Drawing a shape"); }
}
class Circle extends Shape {
  draw(): void { console.log("Drawing a circle"); }
}
class Square extends Shape {
  draw(): void { console.log("Drawing a square"); }
}
const shapes: Shape[] = [new Circle(), new Square()];
shapes.forEach(shape => shape.draw());
// Drawing a circle
// Drawing a square
```

---

## Conclusão

POO facilita a organização, reutilização e manutenção do código, permitindo modelar o mundo real, reutilizar código com herança, modularizar com encapsulamento e estender funcionalidades com polimorfismo.

