package comp;

import gen.languageLexer;
import gen.languageParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class Compilationation {

    public VisitorDataTransmiter calculate(String input) {

        languageLexer lexer = new languageLexer(CharStreams.fromString(input));
        TokenStream tokens = new CommonTokenStream(lexer);

        languageParser parser = new languageParser(tokens);
        LanguageVisitor calculator = new LanguageVisitor();
        ParseTree tree = parser.start();

        return calculator.visit(tree);
    }
}
