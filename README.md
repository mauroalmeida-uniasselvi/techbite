# TechBite

Projeto de aula — aplicação exemplar para demonstrar conceitos de modelagem de domínio e padrões de projeto (fábrica, estratégia, etc.). Este README descreve os módulos principais do sistema e suas responsabilidades, casos de uso e critérios mínimos de aceitação.

---

## Visão geral

O sistema gerencia clientes, produtos, criação de pedidos e pagamentos. Cada módulo deve expor operações claras (CRUD quando aplicável), regras de negócio e validações. Abaixo estão as descrições melhoradas e exemplos de funcionalidades esperadas para cada módulo.

---

## Módulo Cliente

Responsabilidade: manter o cadastro e as categorias de clientes, além de fornecer informações que influenciam regras de negócio (por exemplo, descontos por tipo de cliente).

Funcionalidades principais:
- Criar, ler, atualizar e remover clientes (CRUD).
- Classificar clientes por tipo (Ex.: Comum, Associado, Funcionário).
- Consultar dados do cliente por ID, CPF ou e-mail.
- Consultar regras de desconto/benefícios associadas ao tipo de cliente.

Regras e validações sugeridas:
- Campos obrigatórios: nome, CPF (ou documento), tipo do cliente.
- Validação de formato de CPF/e-mail.
- Evitar duplicidade por CPF ou e-mail.

Casos de uso (exemplos):
- Cadastro de um novo cliente associado com benefício de desconto.
- Atualização do tipo de cliente (de Comum para Associado).
- Consulta dos dados do cliente durante a criação de um pedido para aplicar políticas.

Critérios de aceitação mínima:
- Endpoint/serviço para criar e consultar clientes funciona e valida entrada.
- A classificação do cliente é persistida e consultável.

---

## Módulo Produto

Responsabilidade: gerenciar o catálogo de produtos e o estoque.

Funcionalidades principais:
- CRUD de produtos (nome, descrição, preço unitário, SKU, categoria).
- Gestão de estoque: consultar saldo, reservar quantidade para pedido, atualizar entrada/saída.
- Pesquisa/filtragem por nome, categoria ou faixa de preço.
- Regras de preço (ex.: preço promocional, descontos por categoria).

Regras e validações sugeridas:
- Preço unitário >= 0.
- Quantidade em estoque >= 0.
- Bloquear redução de estoque abaixo de zero (reserva/concorrência tratada pelo serviço de pedido).

Casos de uso (exemplos):
- Inserir novo produto no catálogo.
- Reservar 2 unidades de um produto ao iniciar um pedido.
- Atualizar estoque após pagamento/entrega.

Critérios de aceitação mínima:
- Consultas e criação de produto funcionam com validações.
- Operação de reserva de estoque não permite saldo negativo.

---

## Módulo Pedido

Responsabilidade: criação e manutenção do ciclo de vida de um pedido (itens, descontos, totais) até a finalização do pagamento.

Funcionalidades principais:
- Iniciar um novo pedido (associado a um cliente ou anônimo).
- Adicionar/remover produtos do pedido com quantidade.
- Aplicar descontos (por item, por pedido, vouchers) com validação de regras.
- Visualizar itens, subtotais, impostos e valor total.
- Calcular totais considerando descontos e impostos.
- Transições de status: aberto -> finalizado -> pago -> enviado/entregue/cancelado.
- Persistir histórico do pedido (itens e preços no momento do pedido).

Regras e validações sugeridas:
- Não permitir adicionar ao pedido produtos sem estoque suficiente (ou reservar estoque na criação).
- Calcular impostos e aplicar regras de desconto do cliente automaticamente quando aplicável.
- Manter imutabilidade dos preços registrados no pedido (preço histórico).

Casos de uso (exemplos):
- Cliente adiciona 3 unidades de um produto e visualiza total parcial.
- Sistema aplica automaticamente desconto de 10% para clientes associados.
- Usuário aplica um cupom de desconto válido.

Critérios de aceitação mínima:
- Criação de pedido com itens e cálculo correto do total (incluindo descontos) comprovado por testes simples.
- Gerenciamento de status do pedido suportado e consistente.

Observação operacional (fechamento -> pagamento -> nota):
- Ao FINALIZAR/FECHAR um pedido, o sistema deve criar automaticamente um registro de `Pagamento` vinculado ao pedido. Esse pagamento inicial deve entrar com status PENDENTE.
- O pagamento só altera o status do pedido para PAGO quando o serviço de pagamento atualizar o status para APROVADO.
- Somente após a confirmação do pagamento (status APROVADO) a `NotaFiscal` deve ser gerada e vinculada ao pedido.

Critérios adicionais de aceitação (fluxo financeiro):
- Fechar pedido cria um `Pagamento` com status PENDENTE.
- Fluxo de pagamento permite atualização de status para APROVADO/RECUSADO e registra tentativa/historico.
- Após pagamento APROVADO, o sistema gera automaticamente a `NotaFiscal` e anexa ao pedido.

Checklist de verificação (testes manuais / automáticos):
1. Criar pedido com itens e fechar. Verificar que um `Pagamento` foi criado com status PENDENTE.
2. Simular confirmação de pagamento (APROVADO). Verificar que o pedido passa para status PAGO.
3. Verificar que, após confirmação APROVADA, uma `NotaFiscal` foi criada e vinculada ao pedido.
4. Simular pagamento RECUSADO e verificar que o pedido não muda para PAGO e nenhuma nota é gerada.

---

## Módulo Pagamento

Responsabilidade: processar pagamentos, registrar forma de pagamento e vincular ao pedido; gerar/consultar nota fiscal quando aplicável.

Funcionalidades principais:
- Registrar pagamento por diferentes meios (dinheiro, cartão, PIX, etc.).
- Validar que o valor pago corresponde ao total do pedido (considerando troco quando em dinheiro).
- Integrar com serviços externos de pagamento (simulado) e retornar status (aprovado, recusado, pendente).
- Emitir ou armazenar informações de nota fiscal vinculada ao pedido.

Regras e validações sugeridas:
- Não marcar pedido como pago até confirmação do pagamento.
- Registrar histórico de tentativas de pagamento e motivo de falha.

Casos de uso (exemplos):
- Cliente finaliza pedido e seleciona pagamento por cartão — sistema registra pagamento e muda o status para pago.
# TechBite

Aplicação de referência acadêmica para demonstração de modelagem de domínio e padrões de projeto (Factory, Strategy, etc.). Este documento descreve a arquitetura de alto nível, responsabilidades dos módulos, casos de uso e critérios mínimos de aceitação para testes e validação.

Sumário
- Visão geral
- Módulos e responsabilidades
- Fluxos operacionais críticos
- Considerações técnicas e próximos passos
- Menu (console)

## Visão geral

O projeto gerencia clientes, produtos, pedidos e pagamentos. Cada módulo expõe operações claras (CRUD quando aplicável), regras de negócio e validações. O objetivo deste repositório é fornecer uma base didática para entender padrões de projeto aplicados a um domínio de comércio simples.

## Módulos e responsabilidades

### Cliente

Responsabilidade: gerenciar o cadastro e a classificação de clientes, além de prover informações utilizadas por regras de negócio (descontos, limites, etc.).

Funcionalidades essenciais:
- CRUD de clientes (nome, documento, tipo, contato).
- Classificação por tipo (Comum, Associado, Funcionário).
- Consultas por ID, CPF/CNPJ ou e-mail.

Validações recomendadas:
- Campos obrigatórios: nome, documento, tipo do cliente.
- Validação de formato de CPF/CNPJ e e-mail.
- Evitar duplicidade por documento ou e-mail.

Critério mínimo de aceitação:
- Serviço/endpoint para criar e consultar clientes com validação básica.

### Produto

Responsabilidade: gerenciar catálogo e controle de estoque.

Funcionalidades essenciais:
- CRUD de produtos (nome, descrição, SKU, preço unitário, categoria).
- Consulta e reserva de estoque.
- Pesquisa/filtragem por nome, categoria ou faixa de preço.

Validações recomendadas:
- Preço unitário >= 0.
- Quantidade em estoque >= 0.
- Bloquear operações que resultem em saldo negativo.

Critério mínimo de aceitação:
- Criação e consulta de produto funcionando com validações.

### Pedido

Responsabilidade: ciclo de vida do pedido (itens, descontos, totais, status) até a conclusão do pagamento.

Funcionalidades essenciais:
- Iniciar pedido (com ou sem cliente).
- Adicionar/remover itens com quantidades.
- Aplicar descontos (por item, por pedido, cupons) com validação.
- Calcular subtotais, impostos e total final.
- Transições de status: ABERTO -> FINALIZADO -> PAGO -> ENVIADO/ENTREGUE/CANCELADO.
- Persistir histórico de preços e itens no momento do pedido.

Regras operacionais importantes:
- Não permitir adicionar itens sem estoque disponível (ou reservar ao criar).
- Manter imutabilidade do preço registrado no pedido.

Critério mínimo de aceitação:
- Criação de pedido com itens e cálculo correto do total (testes automatizados simples).

Fluxo financeiro (observação operacional):
- Ao FECHAR um pedido, deve ser criado um registro de `Pagamento` com status PENDENTE.
- O pedido só é marcado como PAGO quando o serviço de pagamento atualizar o status para APROVADO.
- Após confirmação de pagamento APROVADO, uma `NotaFiscal` deve ser gerada e vinculada ao pedido.

### Pagamento

Responsabilidade: registrar e processar pagamentos, validar valores e integrar (simular) provedores externos.

Funcionalidades essenciais:
- Registro de pagamento por meios múltiplos (Dinheiro, Cartão, PIX).
- Validação de valor pago (considerar troco para dinheiro).
- Simular integração com gateways e retornar status (PENDENTE, APROVADO, RECUSADO).
- Registrar histórico de tentativas e motivos de falha.

Critério mínimo de aceitação:
- Pagamento persistido e vinculado ao pedido; nota fiscal consultável a partir do pedido após confirmação.

## Fluxos operacionais críticos

- Fechar pedido -> criar `Pagamento` (PENDENTE).
- Atualizar pagamento -> quando APROVADO: marcar pedido como PAGO e gerar `NotaFiscal`.
- Em caso de pagamento RECUSADO: manter pedido em estado apropriado e registrar tentativa.

Checklist de verificação (manual/automático):
1. Criar pedido com itens e fechar; verificar criação de `Pagamento` com status PENDENTE.
2. Simular pagamento APROVADO; verificar que o pedido passa para PAGO e que a `NotaFiscal` foi gerada.
3. Simular pagamento RECUSADO; verificar que o pedido não é marcado como PAGO.

## Considerações técnicas e próximos passos

- Definir contratos e DTOs entre os módulos (interfaces claras entre Pedido, Cliente e Produto).
- Implementar testes unitários para regras críticas: cálculo de total, aplicação de desconto e reserva de estoque.
- Tratar concorrência de estoque (reservas, mecanismos de bloqueio ou compensação).
- Documentar endpoints e exemplos de payloads (OpenAPI/Swagger ou documento separado).
- Considerar persitência de histórico e versionamento de preço para auditoria.

## Menu (Console)

O projeto inclui telas de console (ex.: `Screen100`, `Screen110`, `Screen111`) para navegação e operações básicas. Abaixo há a estrutura proposta para as telas principais.

Screen 1.0.0 (Screen100) — Menu Principal
1. Gerenciamento — cadastros de clientes e produtos
2. Pedidos — criar, listar e editar pedidos
3. Pagamentos — registrar e listar pagamentos
4. Notas fiscais — gerar e consultar notas
5. Relatórios — relatórios básicos
0. Sair

Screen 1.1.0 (Screen110) — Cadastros
1. Clientes — listar / criar / buscar
2. Produtos — listar / criar / ajustar estoque
0. Voltar

Screen 1.2.0 (Screen120) — Pedidos
1. Criar pedido — iniciar pedido e adicionar itens
2. Listar pedidos — filtrar por status/cliente
3. Ver/Editar pedido — alterar itens/status
0. Voltar

Screen 1.3.0 (Screen130) — Pagamentos
1. Registrar pagamento — escolher forma e confirmar
2. Listar pagamentos — histórico
0. Voltar

Screen 1.4.0 (Screen140) — Notas fiscais
1. Listar notas — consultar por pedido
2. Gerar nota — para pedido pago
0. Voltar


## Outros

Observações rápidas
- Use ‘0’ para voltar ao menu anterior.
- Ao criar pedido, informe cliente (ID) ou escolha anônimo; adicione itens por SKU/ID e quantidade.
- Exibir mensagens claras para erros comuns: cliente não encontrado, estoque insuficiente, pagamento recusado.

## Como compilar e executar (rápido)

Este projeto utiliza Gradle wrapper. Exemplos de comandos:

- Compilar: `./gradlew build`
- Executar: `./gradlew run` (conforme configuração do projeto)

Considere executar os testes e revisar o histórico de classes geradas em `build/`.

---

Fim da documentação principal. Para contribuições e mudanças arquiteturais, abrir uma issue descrevendo o objetivo, API/contrato esperado e impacto nos módulos existentes.


