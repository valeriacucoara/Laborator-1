import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String nume_fisier = "src/main/resources/discipline.txt";

        try {
            File file = new File(nume_fisier);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String disciplina = scan.nextLine();
                list.add(disciplina);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu a fost găsit");
        }

        list.stream()
                .filter(disciplina -> disciplina.startsWith("A"))
                .distinct()
                .sorted((x, y) -> x.compareTo(y))
                .map(String::toUpperCase)
                .forEach(disciplina -> System.out.println(disciplina));

        System.out.println("Disciplinele grupei FI-231");

    }
}