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
                System.out.println("Enter the width of the first envelope:");
                width = scanner.nextDouble();
                System.out.println("Enter the height of the first envelope:");
                height = scanner.nextDouble();

                firstEnvelope = new Envelope(width, height);

                //second envelope
                System.out.println("Enter the width of the second envelope:");
                width = scanner.nextDouble();
                System.out.println("Enter the height of the second envelope:");
                height = scanner.nextDouble();

                secondEnvelope = new Envelope(width, height);

            } catch (NumberFormatException ex) {
                System.out.println("invalid parameters");
            }

            if (firstEnvelope != null && secondEnvelope != null) {
                if ((firstEnvelope.getWidth() < secondEnvelope.getWidth() || firstEnvelope.getWidth() < secondEnvelope.getHeight())
                        &&(firstEnvelope.getHeight() < secondEnvelope.getWidth() || firstEnvelope.getHeight() < secondEnvelope.getHeight())){
                    System.out.println("The second envelope is placed in the first envelope");
                }else if ((secondEnvelope.getWidth() < firstEnvelope.getWidth() || secondEnvelope.getWidth() < firstEnvelope.getHeight())
                        &&(secondEnvelope.getHeight() < firstEnvelope.getWidth() || secondEnvelope.getHeight() < firstEnvelope.getHeight())){
                    System.out.println("The first envelope is placed in the second envelope");
                }
                else {
                    System.out.println("The envelope does not fit another envelope");
                }
            }else {
                System.out.println("invalid parameters");
            }

            System.out.println("Do you want to continue(y/yes)?");
            answer = scanner.next().toLowerCase();

            keepOn = (answer.equals("y") || answer.equals("yes"))?true:false;
        } while (keepOn);
        scanner.close();
    }
}