package exemplos.lista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExercicioLista02 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<String> respostas = new ArrayList<>();
        String resposta = "";
        int contador = 0;

        System.out.println("1. Telefonou para a vítima?");
        resposta = sc.nextLine();
        respostas.add(resposta);

        System.out.println("2. Esteve no local do crime?");
        resposta = sc.nextLine();
        respostas.add(resposta);

        System.out.println("3. Mora perto da vítima?");
        resposta = sc.nextLine();
        respostas.add(resposta);

        System.out.println("4. Devia para a vítima?");
        resposta = sc.nextLine();
        respostas.add(resposta);

        System.out.println("5. Já trabalhou com a vítima?");
        resposta = sc.nextLine();
        respostas.add(resposta);


        for (String resp : respostas) {
            if (resp.toLowerCase().contains("s")) {
                contador++;
            }
        }

        switch (contador) {
            case 2 -> System.out.println("Suspeita");
            case 3, 4 -> System.out.println("Cúmplice");
            case 5 -> System.out.println("Assassina");
            default -> System.out.println("Inocente");
        }

    }
}
