package br.com.alura.screenmatch.principal;

import java.util.HashMap;
import java.util.Map;

public class PrincipalHashMap {
    public static void main(String[] args) {
        //Criando um objeto da classe HashMap que implementa a interface Map
        Map<String, Integer> usandoHashMap = new HashMap<>();

        //Sintaxe - chave, valor
        // Adicionando pares chave-valor
        usandoHashMap.put("Gatos", 1);
        usandoHashMap.put("Cachorros", 2);
        usandoHashMap.put("Roedores", 3);

        // Acessando um valor através de uma chave
        //Aqui é inteiro, pois a chave que é uma String Cachorros tem o valor inteiro
        int valor = usandoHashMap.get("Cachorros");
        System.out.println("Valor da chave Cachorros: " + valor);

        // Removendo um par chave-valor
        usandoHashMap.remove("Gatos");

        // Iterando sobre as chaves
        for (String chave : usandoHashMap.keySet()) {
            System.out.println("Chave: " + chave);
            System.out.println("Valor: " + usandoHashMap.get(chave));
        }
        System.out.println("""
                
                Segundo Exemplo:
                """);
        //Para entender melhor vamos fazer ao contrario
        Map<Integer, String> usandoHashMap2 = new HashMap<>();
        usandoHashMap2.put(1, "One Piece");
        usandoHashMap2.put(2, "Loki");
        usandoHashMap2.put(3, "Star Wars");

        String valorDaChave = usandoHashMap2.get(3);
        System.out.println("Valor da chave 3: " + valorDaChave);

        usandoHashMap2.remove(2);
        for (int chave : usandoHashMap2.keySet()) {
            System.out.println("Chave: " + chave);
            System.out.println("Valor: " + usandoHashMap2.get(chave));
        }
    }
}
