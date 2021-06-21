package exemplos.set;

import java.util.*;

public class ExemploOrdenacaoSet {

    public static void main(String[] args) {

        /* Dadas as seguintes informações sobre minhas séries favoritas,
        * crie um conjunto e ordene o mesmo exibindo:
        * (nome, gênero, tempo de episódio)
        * Série 1 = Nome: Friends, Gênero: Comédia, Tempo de Episódio: 25
        * Série 2 = Nome: Seinfeld, Gênero: Comédia, Tempo de Episódio: 25
        * Série 3 = Nome: Cobra Kai, Gênero: Artes Marciais, Tempo de Episódio: 35*/

        System.out.println("-- Ordem Aleatória --");
        Set<Serie> minhasSeries = new HashSet<>();
        minhasSeries.add(new Serie("Friends", "Comédia", 25));
        minhasSeries.add(new Serie("Seinfeld", "Comédia", 25));
        minhasSeries.add(new Serie("Cobra Kai", "Artes Marciais", 35));

        minhasSeries.forEach(System.out::println);

        System.out.println("-- Ordem Natural (Tempo de Episódio) --");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries);
        minhasSeries2.forEach(System.out::println);

        System.out.println("-- Ordem (Nome, Gênero, Tempo de Episódio) --");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries3.addAll(minhasSeries);
        minhasSeries3.forEach(System.out::println);
    }

}

class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie() {
    }

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public int compareTo(Serie serie) {
        int duracaoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        int tipoGenero = this.getGenero().compareTo(serie.getGenero());
        int nomeSerie = this.getNome().compareTo(serie.getNome());

        if (duracaoEpisodio != 0) {
            return duracaoEpisodio;
        } else if (nomeSerie != 0) {
            return nomeSerie;
        }

        return tipoGenero;
    }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

    @Override
    public int compare(Serie s1, Serie s2) {
        int tipoGenero = s1.getGenero().compareTo(s2.getGenero());
        int nomeSerie = s1.getNome().compareTo(s2.getNome());

        if (tipoGenero != 0) {
            return tipoGenero;
        } else if (nomeSerie != 0) {
            return nomeSerie;
        }

        return s1.getTempoEpisodio().compareTo(s2.getTempoEpisodio());
    }
}