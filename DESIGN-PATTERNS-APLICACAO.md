# Aplicação de Design Patterns no Projeto TechBite

## Sumário
1. [Factory Method](#1-factory-method)
2. [Strategy](#2-strategy)
3. [Observer](#3-observer)
4. [Singleton](#4-singleton)
5. [Template Method](#5-template-method)
6. [Builder](#6-builder)

## 1. Factory Method
**Contexto Atual**: O projeto já possui uma implementação parcial com `FabricaSimplesPagamento`.

**Proposta de Implementação**:
```java
interface Pagamento {
    void processar();


abstract class FabricaPagamento {
    abstract Pagamento criarPagamento();
}

class FabricaPagamentoCartao extends FabricaPagamento {
    @Override
    Pagamento criarPagamento() {
        return new PagamentoCartao();
    }
}

class FabricaPagamentoPix extends FabricaPagamento {
    @Override
    Pagamento criarPagamento() {
        return new PagamentoPix();
    }
}
```

**Benefícios**:
- Encapsulamento da criação de objetos
- Flexibilidade para adicionar novos tipos de pagamento
- Manutenção simplificada

## 2. Strategy
**Contexto**: Diferentes tipos de clientes (Associado, Funcionário, Comum) com diferentes regras de desconto.

**Proposta de Implementação**:
```java
interface CalculadoraDesconto {
    double calcularDesconto(double valor);
}

class DescontoClienteAssociado implements CalculadoraDesconto {
    @Override
    public double calcularDesconto(double valor) {
        return valor * 0.15; // 15% de desconto
    }
}

class DescontoClienteFuncionario implements CalculadoraDesconto {
    @Override
    public double calcularDesconto(double valor) {
        return valor * 0.20; // 20% de desconto
    }
}

class Pedido {
    private CalculadoraDesconto calculadoraDesconto;
    
    public void setCalculadoraDesconto(CalculadoraDesconto calculadora) {
        this.calculadoraDesconto = calculadora;
    }
    
    public double calcularValorComDesconto() {
        return valorTotal - calculadoraDesconto.calcularDesconto(valorTotal);
    }
}
```

**Benefícios**:
- Flexibilidade para adicionar novos tipos de desconto
- Encapsulamento das regras de negócio
- Facilidade de testes unitários

## 3. Observer
**Contexto**: Necessidade de notificar diferentes partes do sistema quando um pedido é realizado.

**Proposta de Implementação**:
```java
interface ObservadorPedido {
    void atualizar(Pedido pedido);
}

class NotificadorNotaFiscal implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        new NotaFiscal().gerar(pedido);
    }
}

class NotificadorEstoque implements ObservadorPedido {
    @Override
    public void atualizar(Pedido pedido) {
        atualizarEstoqueProdutos(pedido.getProdutos());
    }
}

class Pedido {
    private List<ObservadorPedido> observadores = new ArrayList<>();
    
    public void adicionarObservador(ObservadorPedido observador) {
        observadores.add(observador);
    }
    
    public void finalizarPedido() {
        for(ObservadorPedido observador : observadores) {
            observador.atualizar(this);
        }
    }
}
```

**Benefícios**:
- Baixo acoplamento
- Extensibilidade
- Separação de responsabilidades

## 4. Singleton
**Contexto**: Gerenciamento de recursos compartilhados e estado global da aplicação.

**Proposta de Implementação**:
```java
public class GerenciadorSessao {
    private static GerenciadorSessao instance;
    private Cliente clienteAtual;
    
    private GerenciadorSessao() {}
    
    public static synchronized GerenciadorSessao getInstance() {
        if (instance == null) {
            instance = new GerenciadorSessao();
        }
        return instance;
    }
    
    public void setClienteAtual(Cliente cliente) {
        this.clienteAtual = cliente;
    }
    
    public Cliente getClienteAtual() {
        return clienteAtual;
    }
}
```

**Benefícios**:
- Controle centralizado
- Acesso global
- Garantia de instância única

## 5. Template Method
**Contexto**: Padronização do processamento de pedidos com variações por tipo de cliente.

**Proposta de Implementação**:
```java
abstract class ProcessadorPedido {
    public final void processarPedido(Pedido pedido) {
        validarPedido(pedido);
        calcularTotal(pedido);
        aplicarDesconto(pedido);
        finalizarPedido(pedido);
    }
    
    abstract void validarPedido(Pedido pedido);
    abstract void calcularTotal(Pedido pedido);
    
    protected void aplicarDesconto(Pedido pedido) {
        // Implementação padrão
    }
    
    private void finalizarPedido(Pedido pedido) {
        pedido.setStatus("FINALIZADO");
    }
}

class ProcessadorPedidoAssociado extends ProcessadorPedido {
    @Override
    void validarPedido(Pedido pedido) {
        // Validações específicas para associados
    }
    
    @Override
    void calcularTotal(Pedido pedido) {
        // Cálculo com desconto de associado
    }
}
```

**Benefícios**:
- Reutilização de código
- Consistência no processo
- Flexibilidade nas implementações específicas

## 6. Builder
**Contexto**: Construção de pedidos complexos com múltiplos itens e configurações.

**Proposta de Implementação**:
```java
class PedidoBuilder {
    private Pedido pedido = new Pedido();
    
    public PedidoBuilder comCliente(Cliente cliente) {
        pedido.setCliente(cliente);
        return this;
    }
    
    public PedidoBuilder adicionarProduto(Produto produto, int quantidade) {
        pedido.adicionarItem(produto, quantidade);
        return this;
    }
    
    public PedidoBuilder comFormaPagamento(Pagamento pagamento) {
        pedido.setPagamento(pagamento);
        return this;
    }
    
    public Pedido build() {
        if(pedido.getCliente() == null) {
            throw new IllegalStateException("Pedido deve ter um cliente");
        }
        return pedido;
    }
}

// Exemplo de uso:
Pedido pedido = new PedidoBuilder()
    .comCliente(cliente)
    .adicionarProduto(produto1, 2)
    .adicionarProduto(produto2, 1)
    .comFormaPagamento(new PagamentoPix())
    .build();
```

**Benefícios**:
- Construção clara e intuitiva
- Validações durante a construção
- Flexibilidade na ordem de configuração

## Conclusão

A implementação destes padrões de projeto trará diversos benefícios ao projeto TechBite:

1. **Manutenibilidade**: Código mais organizado e fácil de manter
2. **Flexibilidade**: Facilidade para adicionar novos comportamentos
3. **Reusabilidade**: Componentes mais modulares e reutilizáveis
4. **Testabilidade**: Maior facilidade para escrever testes unitários
5. **Escalabilidade**: Melhor preparado para crescimento do sistema

### Próximos Passos

1. Implementar os padrões gradualmente, começando pelos mais críticos
2. Criar testes unitários para as novas implementações
3. Documentar as mudanças e novos comportamentos
4. Treinar a equipe nos novos padrões implementados