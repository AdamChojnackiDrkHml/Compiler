package comp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Core {
    public static void main(String[] args) throws IOException {
        Compilationation comp = new Compilationation();
        Path p = Path.of("/home/adam/Pobrane/testy2021/0-div-mod.imp");
        String read = Files.readString(p);
        comp.calculate(read);
    }
}
