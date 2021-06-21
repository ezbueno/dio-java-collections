package exemplos.map;

import java.util.*;

public class ExemploMap {

    public static void main(String[] args) {
        /* Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
        * modelo = Gol - consumo = 14,4 km/l
        * modelo = Uno - consumo = 15,6 km/l
        * modelo = Mobi - consumo = 16,1 km/l
        * modelo = HB20 - consumo = 14,5 km/l
        * modelo = Kwid = consumo = 15,6 km/l
        */

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos:");
        Map<String, Double> carros = new HashMap<>();
        carros.put("Gol", 14.4);
        carros.put("Uno", 15.6);
        carros.put("Mobi", 16.1);
        carros.put("HB2O", 14.5);
        carros.put("Kwid", 15.6);

        System.out.println(carros);

        System.out.println();

        System.out.println("Substitua o consumo do Gol por 15,2 km/l:");
        carros.put("Gol", 15.2);
        System.out.println(carros);

        System.out.println();

        System.out.println("Confira se o modelo Tucson está no dicionário: " + carros.containsKey("Tucson"));

        System.out.println();

        System.out.println("Exiba o consumo do Uno: " + carros.get("Uno"));

        System.out.println();

        System.out.println("Exiba o terceiro modelo adicionado: ");
        List<String> indexes = new ArrayList<>(carros.keySet());
        System.out.println(indexes.get(2));

        System.out.println();

        System.out.println("Exiba os modelos:");
        Set<String> modelos = carros.keySet();
        System.out.println(modelos);

        System.out.println();

        System.out.println("Exiba os consumos dos carros:");
        Collection<Double> consumos = carros.values();
        System.out.println(consumos);

        System.out.println();

        System.out.println("Exiba o modelo mais econômico e seu consumo:");
        Double consumoMaisEficiente = Collections.max(carros.values());
        Set<Map.Entry<String, Double>> entries = carros.entrySet();

        for (Map.Entry<String, Double> entry : entries) {
            if (consumoMaisEficiente.equals(entry.getValue())) {
                System.out.println("Modelo: " + entry.getKey() + " - " +
                        "Consumo: " + entry.getValue());
            }
        }

        System.out.println();

        System.out.println("Exiba o modelo menos econômico e seu consumo:");
        Double consumoMenosEficiente = Collections.min(carros.values());

        for (Map.Entry<String, Double> entry : entries) {
            if (consumoMenosEficiente.equals(entry.getValue())) {
                System.out.println("Modelo: " + entry.getKey() + " - " +
                        "Consumo: " + entry.getValue());
            }
        }

        System.out.println();

        System.out.println("Exiba a soma dos consumos:");
        Double soma = carros.values().stream().reduce(0d, Double::sum);
        System.out.println(soma);

        System.out.println();

        System.out.println("Exiba a média dos consumos deste dicionário de carros: " + soma / carros.size());

        System.out.println();


        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l:");
        Collection<Double> removerModelos = carros.values();
        removerModelos.removeIf(x -> x.equals(15.6));
        System.out.println(removerModelos);

        System.out.println();

        System.out.println("Exiba todos os carros na ordem em que foram informados:");
        Map<String, Double> cars = new LinkedHashMap<>();
        cars.put("Gol", 14.4);
        cars.put("Uno", 15.6);
        cars.put("Mobi", 16.1);
        cars.put("HB2O", 14.5);
        cars.put("Kwid", 15.6);

        System.out.println(cars);

        System.out.println();

        System.out.println("Exiba o dicionário ordenado pelo modelo:");
        Map<String, Double> ordenarPorModelo = new TreeMap<>(cars);
        System.out.println(ordenarPorModelo);

        System.out.println();

        System.out.println("Apague o dicionário de carros:");
        cars.clear();
        System.out.println(cars);

        System.out.println();

        System.out.println("Confira se o dicionário está vazio: " + cars.isEmpty());

    }

}
