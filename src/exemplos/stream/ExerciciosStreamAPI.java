package exemplos.stream;

import java.util.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {

    public static void main(String[] args) {
        List<String> numerosAleatorios = List.of("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String:");
        numerosAleatorios.forEach(System.out::println);

        System.out.println();

        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Transforme esta lista de String em uma lista de inteiros:");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(n -> n % 2 == 0 && n > 2)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Mostre a média dos números:");
        Double media = numerosAleatorios.stream()
                .mapToDouble(Double::parseDouble)
                .average()
                .orElse(0.0);
        System.out.println(media);

        System.out.println();

        System.out.println("Remova os valores ímpares:");
        List<Integer> numerosImpares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numerosImpares.removeIf(n -> n % 2 != 0);
        System.out.println(numerosImpares);

        System.out.println();

        System.out.println("Ignore os 3 primeiros elementos da lista e imprima o restante:");
        numerosAleatorios.stream()
                .skip(3)
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Retirando os números repetidos da lista, quantos sobram?");
        long contador = numerosAleatorios.stream()
                .distinct()
                .count();
        System.out.println(contador);

        System.out.println();

        System.out.println("Mostre o menor valor da lista:");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .min()
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println("Mostre o maior valor da lista:");
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println();

        System.out.println("Pegue apenas os números ímpares e some:");
        int somaNumerosImpares = numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .filter(n -> n % 2 != 0)
                .reduce(0, Integer::sum);
        System.out.println(somaNumerosImpares);

        System.out.println();

        System.out.println("Mostre a lista na ordem numérica:");
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);

        System.out.println();

        System.out.println("Agrupe os valores ímpares múltiplos de 3 ou 5:");
        List<Integer> numerosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Map<Boolean, List<Integer>> collect = numerosInteger.stream()
                .collect(Collectors.groupingBy(n -> n % 3 == 0 || n % 5 == 0));
        System.out.println(collect);
    }
}
