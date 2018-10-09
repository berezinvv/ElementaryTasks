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
        System.out.println("Enter the path:");
        String path = scanner.nextLine();

        String method = readFile(path);
        System.out.println(method);

        if (method.equals("Moskow")) {
            System.out.println(CountHappyTicketsMoskow());
        } else if (method.equals("Piter")) {
            System.out.println(CountHappyTicketsPiter());
        } else {
            System.out.println("not found method");
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
            System.out.println("invalid parameters");
        }
        return "";
    }

    public static int CountHappyTicketsMoskow() {
        int count = 0;
        for (int ticket = 1; ticket < 1000000; ticket++) {
            if (ticket / 100000 + (ticket / 10000) % 10 + (ticket / 1000) % 10 == (ticket / 100) % 10 + (ticket / 10) % 10 + ticket % 10) {
                count = count + 1;
            }
        }
        return count;
    }

    public static int CountHappyTicketsPiter() {
        int count = 0;
        int evenNumber = 0;
        int oddNumber = 0;
        int curr = 0;
        for (int ticket = 1; ticket < 1000000; ticket++) {
            evenNumber = 0;
            oddNumber = 0;
            for (int i = 1; i <= 100000; i *= 10) {
                if (i != 100000) {
                    curr = (ticket / i) % 10;
                }else {
                    curr = (ticket / i);
                }
                if (curr %2 == 0){
                    evenNumber += curr;
                }else {
                    oddNumber += curr;
                }
            }
            if (evenNumber == oddNumber) {
                count = count + 1;
            }
        }
        return count;
    }
}
