package exemplos.map;

import java.util.*;

public class ExemploOrdenacaoMap {

    private static final String NOME_AUTOR = "Nome do Autor: ";
    private static final String NOME_LIVRO = "Nome do Livro: ";
    private static final String NUMERO_PAGINAS = "Número de Páginas: ";

    public static void main(String[] args) {
        /* Dadas as seguintes informações sobre meus livros favoritos e autores,
         * crie um dicionário e ordene o mesmo, exibindo (nomeLivro do Autor - nomeLivro do Livro).
         * Autor = Hawking, Stephen - Livro = Uma Breve História do Tempo - Páginas = 256
         * Autor = Duhhig, Charles - Livro = O Poder do Hábito, Páginas = 488
         * Autor = Harari, Yuval Noah - Livro = 21 Lições para o Século 21 - Páginas = 432
         */


        Map<String, Livro> livrosHashMap = new HashMap<>();
        livrosHashMap.put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
        livrosHashMap.put("Duhhig, Charles", new Livro("O Poder do Hábito", 488));
        livrosHashMap.put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));

        System.out.println("Ordem aleatória:");
        Set<Map.Entry<String, Livro>> entries = livrosHashMap.entrySet();

        for (Map.Entry<String, Livro> entry : entries) {
            System.out.println(NOME_AUTOR + entry.getKey() + " -- "
                    + NOME_LIVRO + entry.getValue().nomeLivro());
        }

        System.out.println();

        System.out.println("Ordem de inserção:");
        Map<String, Livro> livrosLinkedHashMap = new LinkedHashMap<>();
        livrosLinkedHashMap.put("Hawking, Stephen", new Livro("Uma Breve História do Tempo", 256));
        livrosLinkedHashMap.put("Duhhig, Charles", new Livro("O Poder do Hábito", 488));
        livrosLinkedHashMap.put("Harari, Yuval Noah", new Livro("21 Lições para o Século 21", 432));

        Set<Map.Entry<String, Livro>> entries2 = livrosLinkedHashMap.entrySet();

        for (Map.Entry<String, Livro> entry : entries2) {
            System.out.println(NOME_AUTOR + entry.getKey() + " -- "
                    + NOME_LIVRO + entry.getValue().nomeLivro());
        }

        System.out.println();

        System.out.println("Ordem alfabética por nome do autor:");
        Map<String, Livro> livrosTreeMap = new TreeMap<>(livrosLinkedHashMap);

        Set<Map.Entry<String, Livro>> entries3 = livrosTreeMap.entrySet();

        for (Map.Entry<String, Livro> entry : entries3) {
            System.out.println(NOME_AUTOR + entry.getKey() + " -- "
                    + NOME_LIVRO + entry.getValue().nomeLivro());
        }

        System.out.println();

        System.out.println("Ordem alfabética por nome do livro:");
        Set<Map.Entry<String, Livro>> entries4 = new TreeSet<>(new ComparatorNomeLivro());
        entries4.addAll(livrosHashMap.entrySet());

        for (Map.Entry<String, Livro> entry : entries4) {
            System.out.println(NOME_AUTOR + entry.getKey() + " -- "
                    + NOME_LIVRO + entry.getValue().nomeLivro());
        }

        System.out.println();

        System.out.println("Ordem alfabética por número de página:");
        Set<Map.Entry<String, Livro>> entries5 = new TreeSet<>(new ComparatorNumeroPagina());
        entries5.addAll(livrosHashMap.entrySet());

        for (Map.Entry<String, Livro> entry : entries5) {
            System.out.println(NOME_AUTOR + entry.getKey() + " -- "
                    + NOME_LIVRO + entry.getValue().nomeLivro() + " -- "
                    + NUMERO_PAGINAS + entry.getValue().paginas());
        }

    }
}

record Livro(String nomeLivro, Integer paginas) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nomeLivro.equals(livro.nomeLivro) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeLivro, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nomeLivro='" + nomeLivro + '\'' +
                ", paginas=" + paginas +
                '}';
    }

}

class ComparatorNomeLivro implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().nomeLivro().compareTo(l2.getValue().nomeLivro());
    }
}

class ComparatorNumeroPagina implements Comparator<Map.Entry<String, Livro>> {
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().paginas().compareTo(l2.getValue().paginas());
    }
}

