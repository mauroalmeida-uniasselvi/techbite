
export type TipoCliente = {
    cpf: string
    tipo: string // COMUM ou ASSOCIADO ou FUNCIONARIO
}

export abstract class Cliente {

    private cpf: string;
    private nome: string;
    // não quero usar tipo como atributo, mas poderia 
    // private tipo: string; // "VIP" ou "COMUM"
    protected desconto: number = 0;

    constructor(
        cpf: string,
        nome: string
    ) {
        this.cpf = cpf
        this.nome = nome
    }

    verDesconto() { return this.desconto }
}

export class ClienteComum extends Cliente {
    constructor(
        cpf: string,
        nome: string
    ) {
        super(cpf, nome)
    }
}

export class ClienteAssociado extends Cliente {
    constructor(
        cpf: string,
        nome: string
    ) {
        super(cpf, nome)
        this.desconto = 0.1 // 10% de desconto
    }
}

export class ClienteFuncionario extends Cliente {
    constructor(
        cpf: string,
        nome: string
    ) {
        super(cpf, nome)
        this.desconto = 0.2 // 20% de desconto
    }
}
