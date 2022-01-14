package comp;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Core {
    public static void main(String[] args) throws IOException {
        Compilationation comp = new Compilationation();
        Path p = Path.of("/home/adam/Pobrane/testy2021/AAA");
        String read = Files.readString(p);
        VisitorDataTransmiter data = comp.calculate(read);
        PrintWriter pW = new PrintWriter("/home/adam/Pobrane/labor4/maszyna_wirtualna/test.md");
        String s = String.join("", data.codeHandler);
        pW.println(s);
        pW.close();
    }
}
