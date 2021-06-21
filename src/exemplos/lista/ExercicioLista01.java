package exemplos.lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ExercicioLista01 {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        var sc = new Scanner(System.in);
        List<Double> temperaturas = new ArrayList<>();
        var soma = 0d;
        var media = 0d;


        double[] cont = new double[6];

        for (var i = 0; i < cont.length; i++) {
            System.out.println("Digite a temperatura do mês " + (i + 1) + ":");
            cont[i] = sc.nextDouble();
            temperaturas.add(cont[i]);

            soma += cont[i];
            media = soma / cont.length;
        }

        System.out.println("Média da temperatura: " + media);

        for (var i = 0; i < cont.length; i++) {
            if (temperaturas.get(i) > media) {
                switch (i) {
                    case 0:
                        System.out.println("Temperatura no mês de Janeiro: " + temperaturas.get(i));
                        break;
                    case 1:
                        System.out.println("Temperatura no mês de Fevereiro: " + temperaturas.get(i));
                        break;
                    case 2:
                        System.out.println("Temperatura no mês de Março: " + temperaturas.get(i));
                        break;
                    case 3:
                        System.out.println("Temperatura no mês de Abril: " + temperaturas.get(i));
                        break;
                    case 4:
                        System.out.println("Temperatura no mês de Maio: " + temperaturas.get(i));
                        break;
                    case 5:
                        System.out.println("Temperatura no mês de Junho: " + temperaturas.get(i));
                        break;
                    default:
                        break;
                }
            }
        }

    }
}
