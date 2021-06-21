package exemplos.lista;

import java.util.*;

import static java.lang.System.out;

public class ExemploOrdenacaoLista {

    public static void main(String[] args) {

        var g1 = new Gato("John", 18, "preto");
        var g2 = new Gato("Simba", 6, "listrado");
        var g3 = new Gato("John", 12, "amarelo");

        List<Gato> gatos = new ArrayList<>(Arrays.asList(g1, g2, g3));

        out.println(gatos);

        Collections.sort((gatos));
        out.println(gatos);

        gatos.sort(new ComparatorIdade());
        out.println(gatos);
    }

}

class Gato implements Comparable<Gato> {
    String nome;
    Integer idade;
    String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }

}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato gato1, Gato gato2) {
        return gato1.getIdade().compareTo(gato2.getIdade());
    }

}
