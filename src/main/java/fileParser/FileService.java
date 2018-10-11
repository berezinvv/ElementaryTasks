package fileParser;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {

    public static final String MESSAGE_INFO = "usage: [<path> <substring> <replaceWith>]\n" +
            "\tpath         - path to the file\n" +
            "\tsubstring    - search string\n" +
            "\treplaceWith  - substitution string\n";

    public static long countPoints(String path, String substring) {
        long count = 0;
        Path pathFile = Paths.get(path);

        try {
            List<String> lines = Files.readAllLines(pathFile);

            for (String line : lines) {
                count += line.split(substring, -1).length-1;
            }
        } catch (IOException e) {
            View.printToConcole("invalid parameters\n" + MESSAGE_INFO);
        }

        return count;
    }

    public static void replaceWithStringInFile(String path, String substring, String replaceWith){
        try (Stream<String> lines = Files.lines(Paths.get(path))) {
            List<String> replaced = lines
                    .map(line-> line.replaceAll(substring, replaceWith))
                    .collect(Collectors.toList());
            Files.write(Paths.get(path), replaced);
        } catch (IOException e) {
            View.printToConcole("invalid parameters\n" + MESSAGE_INFO);
        }
    }
}
