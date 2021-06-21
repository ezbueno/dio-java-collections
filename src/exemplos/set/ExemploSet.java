package exemplos.set;

import java.util.*;

import static java.lang.System.out;

public class ExemploSet {

    public static void main(String[] args) {
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        out.println("Exiba o conjunto das notas: " + notas);

        out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));
        out.println("Exiba a menor nota: " + Collections.min(notas));
        out.println("Exiba a maior nota: " + Collections.max(notas));

        out.println();
        Iterator<Double> soma = notas.iterator();
        Double total = 0d;

        while (soma.hasNext()) {
            total += soma.next();
        }

        out.printf("Exiba a soma dos valores: %.2f%n", total);
        out.printf("Exiba a média das notas: %.2f%n", total / notas.size());

        out.println("Remova a nota 0: " + notas.remove(0d));

        notas.removeIf(nota -> nota < 7);
        out.println("Remova as notas menores que 7 e exiba o conjunto: " + notas);

        out.println("Exiba todas as notas na ordem em que foram informadas:");
        Set<Double> notas2 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        out.println(notas2);

        out.println("Exiba todas as notas na ordem crescente:");
        Set<Double> notas3 = new TreeSet<>(notas2);
        out.println(notas3);

        out.println("Apague todo o conjunto:");
        notas.clear();

    }

}
