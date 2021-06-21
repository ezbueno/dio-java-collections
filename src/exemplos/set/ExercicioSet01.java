package exemplos.set;

import java.util.*;

public class ExercicioSet01 {

    public static void main(String[] args) {

        /* Crie um conjunto contendo as cores do arco-íris e:
         * a) Exiba todas as cores uma abaixo da outra
         * b) A quantidade de cores do arco-íris
         * c) Exiba as cores em ordem alfabética
         * d) Exiba as cores na ordem inversa da que foi informada
         * e) Exiba todas as cores que começam com a letra "v"
         * f) Remova todas as cores que não começam com a letra "v"
         * g) Limpe o conjunto
         * h) Confira se o conjunto está vazio
         */

        Set<ArcoIris> cores = new HashSet<>();
        cores.add(new ArcoIris("Violeta"));
        cores.add(new ArcoIris("Anil"));
        cores.add(new ArcoIris("Azul"));
        cores.add(new ArcoIris("Verde"));
        cores.add(new ArcoIris("Amarelo"));
        cores.add(new ArcoIris("Laranja"));
        cores.add(new ArcoIris("Vermelho"));

        System.out.println("Exiba todas as cores uma abaixo da outra");
        cores.forEach(System.out::println);

        System.out.println();

        System.out.println("A quantidade de cores do arco-íris");
        System.out.println("O Arco-íris possui : " + cores.size() + " cores");

        System.out.println();

        System.out.println("Exiba as cores em ordem alfabética");
        Set<ArcoIris> ordenarCor = new TreeSet<>(cores);
        ordenarCor.forEach(System.out::println);

        System.out.println();

        System.out.println("Exiba as cores na ordem inversa da que foi informada");
        Set<String> strCor = new LinkedHashSet<>(Arrays.asList("Violeta", "Anil", "Azul", "Verde", "Amarelo",
                "Laranja", "Vermelho"));
        List<String> listCor = new ArrayList<>(strCor);
        Collections.reverse(listCor);
        listCor.forEach(System.out::println);

        System.out.println();

        System.out.println("Exiba todas as cores que começam com a letra \"v\"");
        cores.stream().filter(x -> x.getCor().startsWith("v".toUpperCase())).forEach(System.out::println);

        System.out.println();

        System.out.println("Remova todas as cores que não começam com a letra \"v\"");
        cores.removeIf(x -> x.getCor().startsWith("v".toUpperCase()));
        cores.forEach(System.out::println);

        System.out.println();

        System.out.println("Limpe o conjunto");
        cores.clear();
        System.out.println(cores);

        System.out.println();

        System.out.println("Confira se o conjunto está vazio");
        System.out.println(cores.isEmpty());

    }
}

class ArcoIris implements Comparable<ArcoIris> {
    private String cor;

    public ArcoIris() {
    }

    public ArcoIris(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArcoIris arcoIris = (ArcoIris) o;
        return cor.equals(arcoIris.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cor);
    }

    @Override
    public String toString() {
        return "ArcoIris{" +
                "cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(ArcoIris cor) {
        return this.getCor().compareTo(cor.getCor());
    }
}