package happyTickets;

import java.util.ArrayList;
import java.util.List;

public class TicketServise {

    public static int CountHappyTicketsMoskow() {
        int count = 0;
        for (int ticket = 1001; ticket < 1000000; ticket++) {
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

        List<Integer> listNumber = new ArrayList<>();
        for (int ticket = 112; ticket < 1000000; ticket++) {
            int number = ticket;

            listNumber.clear();

            while (number > 0) {
                int temp = number % 10;
                listNumber.add(temp);
                number = number / 10;
            }
            evenNumber = listNumber.stream().filter(o -> o % 2 == 0).reduce((s1, s2) -> s1 + s2).orElse(0);
            oddNumber = listNumber.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);

            if (evenNumber == oddNumber && evenNumber != 0 && oddNumber != 0) {
                count = count + 1;
            }
        }
        return count;
    }
}
