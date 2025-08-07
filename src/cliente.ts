
export abstract class Cliente {

    protected cpf: string;
    protected nome: string;
    protected desconto: number = 0;

    constructor(
        cpf: string,
        nome: string
    ) {
        this.cpf = cpf
        this.nome = nome
    }



}