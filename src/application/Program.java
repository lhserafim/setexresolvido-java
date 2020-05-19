package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.*;

public class Program {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter file full path: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            // Criar uma lista set do tipo hashSet()
            Set<LogEntry> set = new HashSet<>(); // Usei o HashSet pq/ é o mais rápido e neste caso n precisa ordenacao
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");
                String userName = fields[0];
                Date moment = Date.from(Instant.parse(fields[1])); // Para pegar a data

                // Inserir no set, com instanciamento
                // A própria estrutura de dados Set impede uma entrada duplicada
                set.add(new LogEntry(userName,moment));

                line = br.readLine();
            }
            System.out.println("Total size: " + set.size());
            for (LogEntry c : set) {
                System.out.println(c);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
