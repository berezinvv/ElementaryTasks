package com.ssitacademy.berezinvv.happyTickets;

import java.util.ArrayList;
import java.util.List;

public enum Method implements CountTicket {

    MOSKOW {
        @Override
        public int CountHappyTickets() {
            int count = 0;
            int countByAmount = 0;

            for (int i = 1; i <= 9 * this.getNumberdigits() / 2/*9+9+9+... first half of the ticket */; i++) {
                //second half of the ticket
                countByAmount = countByAmount(i, 0, this.getNumberdigits() / 2);
                count += countByAmount * countByAmount;
            }
            return count;
        }
    },
    PITER {
        @Override
        public int CountHappyTickets() {
            int count = 0;
            int evenNumber = 0;
            int oddNumber = 0;

            List<Integer> listNumber = new ArrayList<>();
            for (int ticket = 112; ticket < Math.pow(10, this.getNumberdigits()); ticket++) {
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
    };

    private int numberdigits = 6;

    Method() {
    }

    private static int countByAmount(int i, int j, int level) {
        int count = 0;
        if (level > 0) {
            for (int a = 0; a <= 9 && a + j <= i; a++) {
                if (a + j == i) {
                    return count + 1;
                }
                count += countByAmount(i, a + j, level - 1);
            }
        }
        return count;
    }

    public int getNumberdigits() {
        return numberdigits;
    }

    public void setNumberdigits(int numberdigits) {
        if (numberdigits % 2 == 0) {
            this.numberdigits = numberdigits;
        }
    }
}
