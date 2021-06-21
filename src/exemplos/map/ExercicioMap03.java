package exemplos.map;

import java.util.*;

public class ExercicioMap03 {

    /*Dadas as seguintes informações  de id e contato, crie um dicionário e
    * ordene este dicionário exibindo (Nome id - Nome contato)
    * id = 1 - Contato = nome: Simba, número: 2222
    * id = 4 - Contato = nome: Cami, número: 5555
    * id = 3 - Contato = nome: Jhon, número: 1111
    */

    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contato> agenda = new HashMap<>();
        agenda.put(1, new Contato("Simba", 5555));
        agenda.put(4, new Contato("Cami", 1111));
        agenda.put(3, new Contato("Jhon", 2222));

        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry: agenda.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println();

        System.out.println("--\tOrdem de Inserção\t--");
        Map<Integer, Contato> agenda1 = new LinkedHashMap<>();
        agenda.put(1, new Contato("Simba", 5555));
        agenda.put(4, new Contato("Cami", 1111));
        agenda.put(3, new Contato("Jhon", 2222));

        System.out.println(agenda1);
        for (Map.Entry<Integer, Contato> entry: agenda1.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println();

        System.out.println("--\tOrdem id\t--");
        Map<Integer, Contato> agenda2 = new TreeMap<>(agenda);
        System.out.println(agenda2);
        for (Map.Entry<Integer, Contato> entry: agenda2.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }

        System.out.println();

        System.out.println("--\tOrdem do número de telefone\t--");
        //Precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Contato>> set = new TreeSet<>(new ComparatorOrdemNumerica());
        set.addAll(agenda.entrySet());

        for (Map.Entry<Integer, Contato> entry: set) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() +
                    ": " + entry.getValue().getNome());
        }

        System.out.println();

        System.out.println("--\tOrdem do nome do contato\t--");
        //Precisamos organizar os valores. Logo:
        Set<Map.Entry<Integer, Contato>> set1 = new TreeSet<>(new ComparatorOrdemNomeContato());
        set1.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Contato> entry: set1) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
        }
    }
}


class ComparatorOrdemNumerica implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return Integer.compare(cont1.getValue().getNumero(), cont2.getValue().getNumero());
    }
}

class ComparatorOrdemNomeContato implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> cont1, Map.Entry<Integer, Contato> cont2) {
        return cont1.getValue().getNome().compareToIgnoreCase(cont2.getValue().getNome());
    }
}