package br.com.alura.screenmatch.modelos;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota){
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes++;
    }

    public double pegaMedia(){
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }

    //Você quer comparar esse titulo com esse? Pega esse nome (que é uma String, e tem um compareTo também)
    //Delegação na comparação para String, pois ela já sabe ordenar alfabeticamente - this.getNome().delegação
    @Override
    public int compareTo(Titulo outroTitulo) {
        //A chamada this.getNome().compareTo(outroTitulo.getNome()) compara os nomes dos dois títulos. Mesmo que o outroTitulo seja uma instância não inicializada, ele ainda tem um nome
        //(inicializado em branco) porque o atributo nome na classe Titulo foi inicializado no construtor.
        //O método compareTo simplesmente compara esses dois nomes de títulos e os ordena em ordem alfabética com base no valor retornado por compareTo.
        return this.getNome().compareTo(outroTitulo.getNome());
    }
    //this.getNome() obtém o nome do título do objeto atual (o título no qual o método compareTo está sendo chamado).
    //outroTitulo.getNome() obtém o nome do título do objeto que está sendo comparado ao objeto atual (o título passado como argumento outroTitulo ao chamar o método compareTo).
}
