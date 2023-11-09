package br.com.alura.screenmatch;

public class Compra {
    private String descricao;
    private double valor;

    //Construtor
    public Compra(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    //Getters
    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra: descrição = '" + descricao + '\'' +
               " valor = " + valor;
    }
}
