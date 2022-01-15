package comp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Core {
    public static void main(String[] args) throws IOException {
        Compilationation comp = new Compilationation();
        Path p = Path.of("/home/adam/Pobrane/labor4/error0.imp");
        String output = "/home/adam/Pobrane/labor4/maszyna_wirtualna/test.md";
        String read = Files.readString(p);
        comp.calculate(read, output);

    }


}
