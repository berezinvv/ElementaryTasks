package sortTriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String answer = "";
        boolean keepOn = false;
        Scanner scanner = new Scanner(System.in);
        List<Triangle> triangleList = new ArrayList<Triangle>();

        String[] array;

        do {
            try {

                System.out.println("Enter the triangle param (name,firstSide,secondSide,thirdSide)");
                String line = scanner.nextLine();
                array = line.split(",");

                Triangle triangle = new Triangle(array[0], Double.parseDouble(array[1]), Double.parseDouble(array[2]), Double.parseDouble(array[3]));

                triangleList.add(triangle);

            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("invalid parameters");
            }
            System.out.println("Do you want to continue(y/yes)?");
            answer = scanner.next().toLowerCase();
            scanner.nextLine();

            keepOn = (answer.equals("y") || answer.equals("yes"))?true:false;
        } while (keepOn);

        //sort list
        Collections.sort(triangleList);

        System.out.println("======================== Triangle list: ========================");
        for (Triangle triangle: triangleList) {
            System.out.println(triangle);
        }
        scanner.close();
    }
}
