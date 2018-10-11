package envelopeAnalysis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String answer = "";
        boolean keepOn = false;
        double width, height;
        Envelope firstEnvelope = null;
        Envelope secondEnvelope = null;
        Scanner scanner = new Scanner(System.in);
        do {

            try {
                //first envelope
                View.printToConcole("Enter the width of the first envelope:");
                width = scanner.nextDouble();
                View.printToConcole("Enter the height of the first envelope:");
                height = scanner.nextDouble();

                firstEnvelope = new Envelope(width, height);

                //second envelope
                View.printToConcole("Enter the width of the second envelope:");
                width = scanner.nextDouble();
                View.printToConcole("Enter the height of the second envelope:");
                height = scanner.nextDouble();

                secondEnvelope = new Envelope(width, height);

            } catch (NumberFormatException ex) {
                View.printToConcole("invalid parameters");
            }

            if (firstEnvelope != null && secondEnvelope != null) {
                if (firstEnvelope.isFitIntoOther(secondEnvelope)) {
                    View.printToConcole("The envelope is placed in the another envelope");
                } else {
                    View.printToConcole("The envelope does not fit another envelope");
                }
            } else {
                View.printToConcole("invalid parameters");
            }

            View.printToConcole("Do you want to continue(y/yes)?");
            answer = scanner.next().toLowerCase();

            keepOn = (answer.equals("y") || answer.equals("yes")) ? true : false;
        } while (keepOn);
        scanner.close();
    }
}
