package comp;

import org.junit.jupiter.api.Test;
class CodeGeneratorTest {

    @Test
    void test_genConst() {
        CodeGenerator cg = new CodeGenerator();

        cg.genConst(100, Registers.B);

        assert !cg.sb.toString().equals(" ");
        System.out.println(cg.sb.toString());
    }

    @Test
    void mul() {
        CodeGenerator cg = new CodeGenerator();
        Variable var1 = new Variable(1);
        Variable var2 = new Variable(2);

        var1.setValue(3);
        var2.setValue(5);
        cg.mul(var1, var2);
        System.out.println(cg.sb.toString());

    }

    @Test
    void div() {
    }

    @Test
    void mod() {
        CodeGenerator cg = new CodeGenerator();
        Variable var1 = new Variable(1);
        Variable var2 = new Variable(2);

        var1.setValue(-12);
        var2.setValue(5);
        cg.mod(var1, var2);
        System.out.println(cg.sb.toString());
    }
}