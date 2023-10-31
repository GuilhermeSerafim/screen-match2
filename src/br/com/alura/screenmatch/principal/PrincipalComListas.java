package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("Avatar", 2023);
        outroFilme.avalia(6);
        Filme filmeDoPaulo = new Filme("Dogville", 2003);
        filmeDoPaulo.avalia(10);
        Serie lost = new Serie("Lost", 2000);
        Filme aliens = new Filme("Aliens VS Humanos", 2000); //Como usamos 2 criterios de comparar para exibir sequencialmente, esse será exibido primeiro que o Lost

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);
        lista.add(aliens);
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
        System.out.println("//////////////////");
        //Desafio
        Filme matrix = new Filme("Matrix", 1999);
        matrix.avalia(10);
        Filme deadpool3 = new Filme("Deadpool 3", 2024);
        deadpool3.avalia(4);
        Serie onePiece = new Serie("One Piece", 1997);
        onePiece.avalia(10);

        ArrayList<Titulo> vouAssistir = new ArrayList<>();
        vouAssistir.add(matrix);
        vouAssistir.add(deadpool3);
        vouAssistir.add(onePiece);
        //foreach
        for(Titulo titulo : vouAssistir) {
            System.out.println(titulo.getNome());
            if(titulo instanceof Filme filme) { // Se essa verificação for verdadeira, a variável filme é declarada e o objeto titulo é implicitamente convertido (cast) para a classe Filme.
                System.out.println("Classificação: " + filme.getClassificacao());
            } else {
                System.out.println("Série não tem classificação");
            }
        }

        System.out.println("////////////////");
        //for tradicional
        for (int i = 0; i < vouAssistir.size(); i++ ) {
            Titulo titulo = vouAssistir.get(i);
            System.out.println(titulo.getNome());
            if (titulo instanceof Filme) {
                Filme filme = (Filme) titulo;
                System.out.println("Classificação: " + filme.getClassificacao());
            } else {
                System.out.println("Série não tem classificação");
            }
            //Embora o loop for each seja mais legível e fácil de usar para iterar sobre coleções, o loop for tradicional é útil quando você precisa acessar elementos por índices ou
            // quando deseja ter mais controle sobre a iteração. Certifique-se de que o índice i esteja dentro dos limites da lista para evitar exceções de índice fora do intervalo.
        }
        System.out.println("////////////////");
        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Paulo");
        buscaPorArtista.add("Jaqueline");
        buscaPorArtista.add("Guilherme");
        System.out.println(buscaPorArtista); //Aqui é imprimido na ordem que o item foi adicionado
        Collections.sort(buscaPorArtista);
        System.out.println("Depois da ordenação");
        System.out.println(buscaPorArtista);
        System.out.println("///////////");
        System.out.println(lista);
        Collections.sort(lista); //Não vai funcionar pois nossa lista não tem um criterio de ordenação
        //Ou seja, esse o sort, ele aceita listas de objetos que obrigatoriamente saiba
        System.out.println("Depois da ordenação por ordem alfabética: ");
        System.out.println(lista);
        
        //Maneira moderna de se ordenar no Java
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Depois da ordenação por ano de lançamento: ");
        System.out.println(lista);

    }
}
