package projava;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;



public class ReadFile {
    public static void main(String[] args) throws IOException {
        var p = Path.of("test.txt");
        String s = Files.readString(p);
        System.out.println(s);
    }
}

