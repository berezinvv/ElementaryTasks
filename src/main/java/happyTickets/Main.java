package happyTickets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View.printToConcole("Enter the path:");
        String path = scanner.nextLine();

        String method = readFile(path);
        View.printToConcole("Method: " + method);

        if (method.equals("Moskow")) {
            View.printToConcole("Count of happy tickets: " + TicketServise.CountHappyTicketsMoskow());
        } else if (method.equals("Piter")) {
            View.printToConcole("Count of happy tickets: " + TicketServise.CountHappyTicketsPiter());
        } else {
            View.printToConcole("not found method");
        }
    }

    public static String readFile(String path) {
        Path pathFile = Paths.get(path);

        try {
            List<String> lines = Files.readAllLines(pathFile);

            for (String line : lines) {
                return line;
            }
        } catch (IOException e) {
            View.printToConcole("invalid parameters");
        }
        return "";
    }
}
