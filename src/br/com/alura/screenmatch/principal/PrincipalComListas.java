package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        for (Titulo item : lista) {
            System.out.println(item.getNome());
            //Usar instanceof e casting desse modo geralmente indica que
            // o código não está tirando total proveito do polimorfismo e do design orientado a objetos.
            // É preferível projetar o código de maneira que seja possível evitar a necessidade de usar instanceof realizar castings explícitos.
            if (item instanceof Filme filme && filme.getClassificacao() > 2) { //Note que tem como colocarmos mais verificações
                //Já perguntamos e já declaramos a variavel
                //Filme filme = (Filme) item; Nas versões atuais, não preciso usar esse casting
                System.out.println("Classificação: " + filme.getClassificacao());
            } else {
                System.out.println("Não tem classificação");
            }//Abordamos essa prática, pois podemos ver isso ainda em muito código
        }
        //Aqui estamos criando uma variavel filmeVariante que se referencia ao mesmo lugar que o
        //referenciaParaOMesmoLocalDoFilmeVariante se referencia(ou apontam), não estamos copiando o objeto
        //Logo, na realidade é o mesmo lugar de referencia do objeto
        var filmeVariante = new Filme("Qualquer filme", 2021);
        Filme referenciaParaOMesmoLocalDoFilmeVariante = filmeVariante;
        //Variavel referencia é o que a gente usa para chegar até um objeto, note que dá para a gente utilizar os metodos do mesmo
        //Na realidade é o mesmo objeto
        System.out.println(filmeVariante.getNome() + " e " + referenciaParaOMesmoLocalDoFilmeVariante.getNome());
    }

}
