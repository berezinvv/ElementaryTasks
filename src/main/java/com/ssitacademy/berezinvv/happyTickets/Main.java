package com.ssitacademy.berezinvv.happyTickets;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path:");
        String path = scanner.nextLine();

        String method = null;
        try {
            method = readFile(path);
        } catch (IOException ex) {
            System.out.println("invalid parameter");
        }

        System.out.println("Method: " + method);

        if (method != null) {
            System.out.println(Method.valueOf(method.toUpperCase()).CountHappyTickets());
        }else{
            System.out.println("method not defined");
        }
    }

    public static String readFile(String path) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        return bufferedReader.readLine();
    }
}
