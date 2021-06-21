package exemplos.set;

import java.util.*;

public class ExercicioSet02 {

    public static void main(String[] args) {

        /* Crie uma classe chamada LinguagemFavorita que possua os atributos:
        nome, anoCriacao, ide. Em seguida, crie um conjunto com 3 linguagens e
        faça um programa que ordene por:
        a) Ordem de Inserção
        b) Ordem Natural (Nome da Linguagem)
        c) Ordenar (Nome da IDE)
        d) Ordenar (Ano de criação e Nome)
        e) Ordenar (Nome, ano de criação e IDE)
        Ao final, exiba as linguagens no console, uma abaixo da outra
        */

        System.out.println("Ordem de Inserção");
        Set<LinguagemFavorita> linguagens = new LinkedHashSet<>();
        linguagens.add(new LinguagemFavorita("Java", 1995, "Eclipse"));
        linguagens.add(new LinguagemFavorita("C#", 2000, "Visual Studio"));
        linguagens.add(new LinguagemFavorita("C", 1972, "Dev-C++"));
        linguagens.forEach(System.out::println);

        System.out.println();

        System.out.println("Ordem Natural (Nome da Linguagem)");
        Set<LinguagemFavorita> ordenarNome = new TreeSet<>(linguagens);
        ordenarNome.forEach(System.out::println);

        System.out.println();

        System.out.println("Ordenar (Nome da IDE)");
        Set<LinguagemFavorita> ordenarNomeIDE = new TreeSet<>(new ComparatorIDE());
        ordenarNomeIDE.addAll(linguagens);
        ordenarNomeIDE.forEach(System.out::println);

        System.out.println();

        System.out.println("Ordenar (Ano de criação e Nome)");
        Set<LinguagemFavorita> ordenarNomeAnoCriacao = new TreeSet<>(new ComparatorAnoCriacaoNome());
        ordenarNomeAnoCriacao.addAll(linguagens);
        ordenarNomeAnoCriacao.forEach(System.out::println);

        System.out.println();

        System.out.println("Ordenar (Nome, ano de criação e IDE)");
        Set<LinguagemFavorita> ordenarNomeAnoCriacaoIDE = new TreeSet<>(new ComparatorNomeAnoCriacaoIDE());
        ordenarNomeAnoCriacaoIDE.addAll(linguagens);
        ordenarNomeAnoCriacaoIDE.forEach(System.out::println);

    }
}

class LinguagemFavorita implements Comparable<LinguagemFavorita> {
    private String nome;
    private Integer anoCriacao;
    private String ide;

    public LinguagemFavorita(String nome, Integer anoCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(Integer anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    public void setIde(String ide) {
        this.ide = ide;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LinguagemFavorita that = (LinguagemFavorita) o;
        return nome.equals(that.nome) && anoCriacao.equals(that.anoCriacao) && ide.equals(that.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoCriacao, ide);
    }

    @Override
    public String toString() {
        return "LinguagemFavorita{" +
                "nome='" + nome + '\'' +
                ", anoCriacao=" + anoCriacao +
                ", ide='" + ide + '\'' +
                '}';
    }

    @Override
    public int compareTo(LinguagemFavorita linguagem) {
        return this.getNome().compareTo(linguagem.getNome());
    }
}

class ComparatorIDE implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        return l1.getIde().compareTo(l2.getIde());
    }
}

class ComparatorAnoCriacaoNome implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int anoCriacao = l1.getAnoCriacao().compareTo(l2.getAnoCriacao());

        if (anoCriacao != 0) {
            return anoCriacao;
        }

        return l1.getNome().compareTo(l2.getNome());
    }
}

class ComparatorNomeAnoCriacaoIDE implements Comparator<LinguagemFavorita> {
    @Override
    public int compare(LinguagemFavorita l1, LinguagemFavorita l2) {
        int linguagem = l1.getNome().compareTo(l2.getNome());
        int anoCriacao = Integer.compare(l1.getAnoCriacao(), l2.getAnoCriacao());

        if (linguagem != 0) {
            return linguagem;
        } else if (anoCriacao != 0) {
            return anoCriacao;
        }

        return l1.getIde().compareTo(l2.getIde());
    }
}
