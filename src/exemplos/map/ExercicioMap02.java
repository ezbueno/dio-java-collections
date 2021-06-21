package exemplos.map;

import java.util.*;

import static java.lang.String.format;
import static java.lang.System.*;

public class ExercicioMap02 {
    /* Faça um programa que simule um lançamento de dados
    * Lance o dado 100 vezes e armazene
    * Depois, mostre quantas vezes cada valor foi inserido
    */

    public static void main(String[] args) throws InterruptedException {
        int quantLancamentos = 100;

        List<Integer> valores = new ArrayList<>();
        Random geradorLancamento = new Random();
        for (int i = 0; i < quantLancamentos; i++) {
            int number = geradorLancamento.nextInt(6) + 1;
            valores.add(number);
        }

        Map<Integer, Integer> lancamentos = new HashMap<>();
        for (Integer resultado : valores) {
            if (lancamentos.containsKey(resultado)) {
                lancamentos.put(resultado, (lancamentos.get(resultado) + 1));
            } else {
                lancamentos.put(resultado, 1);
            }
        }

        out.print("Jogando");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(3000);
            out.print(".");
        }

        out.println("\nValor " + " Quant. de vezes");
        for (Map.Entry<Integer, Integer> entry : lancamentos.entrySet()) {
            System.out.printf("%3d%10d%n", entry.getKey(), entry.getValue());
        }
    }
}
