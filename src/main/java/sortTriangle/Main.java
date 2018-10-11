package sortTriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static final String MESSAGE_INFO = "usage: [<name>,<firstSide>,<secondSide>,<thirdSide>]\n" +
            "\tname       - triangle name\n" +
            "\tfirstSide  - value of the first side of the triangle\n" +
            "\tsecondSide - value of the second side of the triangle\n" +
            "\tthirdSide  - value of the third side of the triangle\n";

    public static void main(String[] args) {

        String answer = "";
        boolean keepOn = false;
        Scanner scanner = new Scanner(System.in);
        List<Triangle> triangleList = new ArrayList<Triangle>();

        String[] array;

        do {
            try {

                View.printToConcole("Enter the triangle param (name,firstSide,secondSide,thirdSide)");
                String line = scanner.nextLine();
                array = line.split(",");

                Triangle triangle = new Triangle(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]));

                triangleList.add(triangle);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                View.printToConcole("invalid parameters\n" + MESSAGE_INFO);
            }
            View.printToConcole("Do you want to continue(y/yes)?");
            answer = scanner.next().toLowerCase();
            scanner.nextLine();

            keepOn = (answer.equals("y") || answer.equals("yes")) ? true : false;
        } while (keepOn);

        //sort list
        Collections.sort(triangleList);

        View.printToConcole("======================== Triangle list: ========================");
        for (Triangle triangle : triangleList) {
            View.printToConcole(triangle.toString());
        }
        scanner.close();
    }
}
