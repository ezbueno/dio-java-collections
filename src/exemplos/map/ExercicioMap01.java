package exemplos.map;

import java.util.*;

public class ExercicioMap01 {

    public static void main(String[] args) {
        /* Dada a população estimada de alguns estados do NE brasileiro, faça:
         * Estado = PE - População = 9.616.621
         * Estado = AL - População = 3.351.543
         * Estado = CE - População = 9.187.103
         * Estado = RN - População = 3.534.265
         * - Crie um dicionário e relacione os estados e suas populações
         * - Substitua a população do estado do RN por 3.534.165
         * - Confira se o estado PB está no dicionário, caso não, adicione: PB - 4.039.277
         * - Exiba a população PE
         * - Exiba todos os estados e suas populações na ordem em que foi informado
         * - Exiba os estados e suas populações em ordem alfabética
         * - Exiba o estado com a menor população e sua quantidade
         * - Exiba o estado com a maior população e sua quantidade
         * - Exiba a soma da população desses estados
         * - Exiba a média da população deste dicionário de estados
         * - Remova os estados com a população menor que 4.000.000
         * - Apague o dicionário de estados
         * - Confira se o dicionário está vazio
         */

        System.out.println("Crie um dicionário e relacione os estados e suas populações:");
        Map<String, Integer> estados = new HashMap<>();
        estados.put("PE", 9616621);
        estados.put("AL", 3351543);
        estados.put("CE", 9187103);
        estados.put("RN", 3534265);
        System.out.println(estados);

        System.out.println();

        System.out.println("Substitua a população do estado do RN por 3.534.165:");
        estados.put("RN", 3534165);
        System.out.println(estados);

        System.out.println();

        System.out.println("Confira se o estado PB está no dicionário, caso não, adicione: PB - 4.039.277:");
         if (!estados.containsKey("PB")) {
             estados.put("PB", 4039277);
         }
        System.out.println(estados);

        System.out.println();

        System.out.println("Exiba a população PE:");
        System.out.println(estados.get("PE"));

        System.out.println();

        System.out.println("Exiba todos os estados e suas populações na ordem em que foi informado:");
        Map<String, Integer> estados2 = new LinkedHashMap<>();
        estados2.put("PE", 9616621);
        estados2.put("AL", 3351543);
        estados2.put("CE", 9187103);
        estados2.put("RN", 3534265);
        System.out.println(estados2);

        System.out.println();

        System.out.println("Exiba os estados e suas populações em ordem alfabética:");
        Map<String, Integer> estados3 = new TreeMap<>();
        estados3.put("PE", 9616621);
        estados3.put("AL", 3351543);
        estados3.put("CE", 9187103);
        estados3.put("RN", 3534265);
        System.out.println(estados3);

        System.out.println();

        System.out.println("Exiba o estado com a menor população e sua quantidade:");
        Integer menorPopulacao = Collections.min(estados.values());

        for (Map.Entry<String, Integer> entry : estados.entrySet()) {
            if (entry.getValue().equals(menorPopulacao)) {
                System.out.println(entry.getKey() + " -- " + entry.getValue());
            }
        }

        System.out.println();

        System.out.println("Exiba o estado com a maior população e sua quantidade:");
        Integer maiorPopulacao = Collections.max(estados.values());

        for (Map.Entry<String, Integer> entry : estados.entrySet()) {
            if (entry.getValue().equals(maiorPopulacao)) {
                System.out.println(entry.getKey() + " -- " + entry.getValue());
            }
        }

        System.out.println();

        System.out.println("Exiba a soma da população desses estados:");
        Collection<Integer> soma = estados.values();
        Integer total =  soma.stream().reduce(0, Integer::sum);
        System.out.println(total);

        System.out.println();

        System.out.println("Exiba a média da população deste dicionário de estados: " + total / estados.size());

        System.out.println();

        System.out.println("Remova os estados com a população menor que 4.000.000:");
        System.out.println("Antes da remoção: " + estados);
        estados.values().removeIf(x -> x < 4000000);
        System.out.println("Após a remoção: " + estados);

        System.out.println();

        System.out.println("Apague o dicionário de estados:");
        estados.clear();
        System.out.println(estados);

        System.out.println();

        System.out.println("Confira se o dicionário está vazio: " + estados.isEmpty());

    }
}
