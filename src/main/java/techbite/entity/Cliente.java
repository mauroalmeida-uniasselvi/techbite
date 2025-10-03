package techbite.entity;

public abstract class Cliente {
    private String cpf;
    private String nome;
    protected double desconto = 0.0;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public double verDesconto() {
        return desconto;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
