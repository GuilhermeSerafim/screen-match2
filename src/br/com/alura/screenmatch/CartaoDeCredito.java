package br.com.alura.screenmatch;

import java.util.ArrayList;
import java.util.List;

public class CartaoDeCredito {
    private double limite;
    private double saldo;
    private List<Compra> compras;

    //Construtor
    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    //Metodos
    public boolean lancaCompra(Compra compra) {
        if (this.saldo > compra.getValor()) {
            saldo -= compra.getValor();
            this.compras.add(compra);
            return true;
        } else {
            return false;
        }
    }

    //Getters
    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getCompras() {
        return compras;
    }
}