package fileParser;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileService {
    public static int countPoints(String path, String substring) {
        int count = 0;
        Path pathFile = Paths.get(path);

        try {
            List<String> lines = Files.readAllLines(pathFile);

            for (String line : lines) {
                count += line.split(substring, -1).length-1;
            }
        } catch (IOException e) {
            System.out.println("invalid parameters");
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
            System.out.println("invalid parameters");
        }
    }
}
