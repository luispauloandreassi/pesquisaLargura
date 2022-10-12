import javax.management.Query;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<String>> tabela =
                new Hashtable<String, ArrayList<String>>();

        ArrayList<String> vizinhosJuan
                = new ArrayList<String>();
        vizinhosJuan.add("Maria");
        vizinhosJuan.add("Milena");
        vizinhosJuan.add("Lucia");

        ArrayList<String> vizinhosAndres
                = new ArrayList<String>();
        vizinhosAndres.add("Milena");

        ArrayList<String> vizinhosJavier
                = new ArrayList<String>();
        vizinhosJavier.add("Andres");
        vizinhosJavier.add("Milena");
        vizinhosJavier.add("Yadira");

        ArrayList<String> vizinhosYadira
                = new ArrayList<String>();
        vizinhosYadira.add("Lucia");

        ArrayList<String> vizinhosMilena
                = new ArrayList<String>();
        vizinhosMilena.add("Juan");
        vizinhosMilena.add("Yadira");

        tabela.put("Juan", vizinhosJuan);
        tabela.put("Andres", vizinhosAndres);
        tabela.put("Javier", vizinhosJavier);
        tabela.put("Yadira", vizinhosYadira);
        tabela.put("Milena", vizinhosMilena);

        showData(tabela);

        System.out.println(pesquisaEmLargura(tabela, "Juan"));
    }

    private static String pesquisaEmLargura(Hashtable<String, ArrayList<String>> tabela, String verticeInicial){
        Queue<String> fila = new LinkedList<String>();
        ArrayList<String> verificados = new ArrayList<String>();

        fila = enfileirar(fila, (ArrayList<String>)tabela.get(verticeInicial));

        while(fila.size() > 0){
            String pessoa = fila.poll();

            if ("Maria".equals(pessoa))
                return "Juan encontrou Maria!";

            if (verificados.contains(pessoa))
                continue;

            fila = enfileirar(fila, (ArrayList<String>)tabela.get(pessoa));
            verificados.add(pessoa);
        }

        return "Maria nao foi encontrada!";
    }

    private static Queue<String> enfileirar(Queue<String> fila, ArrayList<String> lista){
        if (lista == null)
            return fila;

        for (String item : lista){
            fila.offer(item);
        }

        return fila;
    }

    private static void showData(Hashtable<String, ArrayList<String>> tabela){
        for (Map.Entry<String, ArrayList<String>> entry : tabela.entrySet()){
            String chave = entry.getKey();
            ArrayList<String> dados = entry.getValue();

            System.out.println("Chave: " + chave + " Dados: " + dados);
        }
    }
}