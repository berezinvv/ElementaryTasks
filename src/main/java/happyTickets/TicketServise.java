package happyTickets;

import java.util.ArrayList;
import java.util.List;

public class TicketServise {

    public static int CountHappyTicketsMoskow() {
        int count = 0;
        int countByAmount = 0;

        for (int i = 1; i <= 27/*9+9+9 first half of the ticket */; i++) {
            //second half of the ticket
            countByAmount = 0;
            for (int a = 0; a <= 9 && a <= i; a++) {
                if (a == i) {
                    countByAmount++;
                    break;
                }
                for (int b = 0; b <= 9 && a + b <= i; b++) {
                    if (a + b == i) {
                        countByAmount++;
                        break;
                    }
                    for (int c = 0; c <= 9 && a + b + c <= i; c++) {
                        if (a + b + c == i) {
                            countByAmount++;
                            break;
                        }
                    }
                }
            }
            count += countByAmount * countByAmount;
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
