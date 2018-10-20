package com.ssitacademy.berezinvv.fileParser;

import com.ssitacademy.berezinvv.validator.InputValidator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            if (InputValidator.isContainsCountParametersArray(args,2)) {//number of line entries
                String path = args[0];
                String substring = args[1];
                System.out.println("number of line entries = " + FileService.countPoints(path, substring));
            } else if (InputValidator.isContainsCountParametersArray(args,3)) { //replaceWithStringInFile
                String path = args[0];
                String substring = args[1];
                String replaceWith = args[2];
                FileService.replaceWithStringInFile(path, substring, replaceWith);
            } else {
                System.out.println("invalid parameters\n" + FileService.MESSAGE_INFO);
            }
        } catch (NumberFormatException | IOException ex) {
            System.out.println("invalid parameters\n" + FileService.MESSAGE_INFO);
        }
    }
}
