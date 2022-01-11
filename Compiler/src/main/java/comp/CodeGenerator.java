package comp;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static comp.Registers.*;

public class CodeGenerator
{
    StringBuilder sb = new StringBuilder();
    DataHandler dh;
    private long offset = 0;

    void writeEnd() {
        sb.append("HALT\n");
        offset++;
    }

    void writeCode(String path) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.dir") + path), StandardCharsets.UTF_8))) {
            writer.write(sb.toString());
        }
    }

    void addSingle(String op)
    {
        sb.append(op);
        offset++;
    }

    /**
     * Writes wanted constant to given register.
     * Use registers A and B
     * ALL PREV DATA WILL BE LOST
     */
    public void genConst(long con, Registers reg)
    {
        StringBuilder s = new StringBuilder();
        s.append("RESET A\n");
        s.append("RESET B\n");
        s.append("INC B\n");
        offset += 3;
        String bo = Long.toBinaryString(con);
        char[] bits = bo.toCharArray();
        for(char bit : bits)
        {
            if(bit == '1')
            {
                s.append("INC A\nSHIFT B\n");
                offset += 2;
            }
            else
            {
                s.append("SHIFT B\n");
                offset++;
            }
        }
        s.append("SWAP ").append(reg.toString()).append("\n");
        offset++;

        sb.append(s);

    }

    /**
     * Saves value from register to mem.
     */
    void saveRegToMem(Variable var, Registers r)
    {
        if (r == A)
        {
            sb.append("SWAP C\n");
            getMemAddrInRegA(var);
            sb.append("SWAP C\n");
            sb.append("STORE C\n");
            offset+=3;
        }
        else if(r == B)
        {
            sb.append("SWAP B\n");
            sb.append("SWAP C\n");
            getMemAddrInRegA(var);
            sb.append("SWAP C\n");
            sb.append("STORE C\n");
            offset+=4;
        }
        else
        {
            getMemAddrInRegA(var);
            sb.append("SWAP ").append(r).append("\n");
            sb.append("STORE ").append(r).append("\n");
            offset+=2;
        }
    }

    void getMemFromReg(Variable var, Registers r)
    {
        getMemAddrInRegA(var);
        sb.append("LOAD A\nSWAP ").append(r).append("\n");
        offset+=2;
    }

    void getVarVal(Variable var, Registers r)
    {
        if(!var.isSet())
        {
            genConst(var.getAddress(), r);
        }
        else
        {
            getMemFromReg(var, r);
        }
    }

    void getVarValInAB(Variable var1, Variable var2)
    {
        getVarVal(var1, A);
        sb.append("SWAP C");
        getVarVal(var2, B);
        sb.append("SWAP C");
    }

    void getMemAddrInRegA(Variable var)
    {
        genConst(var.getAddress(), A);
    }

    void arrayOffset(long addres, long offset)
    {
    }

    //
    //IO//
    //
    void read(Variable var)
    {
        sb.append("(START READ)\n");
        sb.append("GET\n");
        offset++;
        saveRegToMem(var, A);
        var.setSet(true);
    }

    void write(Variable var)
    {
        sb.append("(START WRITE)\n");
        getVarVal(var, A);
        sb.append("WRITE\n");
        offset++;
    }
    //
    //ASSIGN//
    //
    void assign(Variable var)
    {
        sb.append("(START ASSIGN)\n");
        saveRegToMem(var, A);
    }


    //
    //OPERATIONS//
    //

    void getConstant(Variable var)
    {
        getVarVal(var, B);
    }

    void add(Variable var1, Variable var2)
    {
        sb.append("(START ADD)\n");
        getVarValInAB(var1, var2);
        sb.append("ADD B\n");
        offset++;
    }

    void sub(Variable var1, Variable var2)
    {
        sb.append("(START SUB)\n");
        getVarValInAB(var1, var2);
        sb.append("SUB B\n");
        offset++;
    }

    void mul(Variable var1, Variable var2)
    {
        sb.append("(START MUL)\n");

        if(var1.getValue() == 0 || var2.getValue() == 0)
        {
            sb.append("RESET A\n");
            offset++;
            return;
        }

        getVarValInAB(var1, var2);
        sb.append("SWAP C\n");
        sb.append("ADD C\n");

        sb.append("JZERO 32\n"); //JUMP IF VAR1 0
        sb.append("SWAP B\n");
        sb.append("JZERO 32\n"); //JUMP IF VAR2 0
        sb.append("SWAP B\n");

        sb.append("JPOS 4\n"); //JUMP TO IF A > 0
        sb.append("SWAP B\n"); //SWAP Bval -> Areg
        sb.append("JPOS 22\n"); //JUMP TO IF A < 0 & B > 0
        sb.append("JNEG 15\n"); //JUMP TO IF A < 0 & B < 0
        sb.append("SWAP B\n");  // SWAP Bval -> Areg
        sb.append("JPOS 7\n"); //JUMP TO IF A > 0 & B > 0
        //Code If A > 0 & B < 0
        sb.append("SWAP B\n");
        sb.append("SUB C\n");
        sb.append("INC B\n");
        sb.append("SWAP B\n");
        sb.append("JZERO -4\n");
        sb.append("JUMP 18\n");
        //Code If A > 0 & B > 0
        sb.append("SWAP B\n");
        sb.append("ADD C\n");
        sb.append("DEC B\n");
        sb.append("SWAP B\n");
        sb.append("JZERO -4\n");
        sb.append("JUMP 12\n");
        //Code If A < 0 & B < 0
        sb.append("SWAP B\n");
        sb.append("SUB C\n");
        sb.append("INC B\n");
        sb.append("SWAP B\n");
        sb.append("JZERO -4\n");
        sb.append("JUMP 6\n");
        //Code If A < 0 & B > 0
        sb.append("SWAP B\n");
        sb.append("ADD C\n");
        sb.append("DEC B\n");
        sb.append("SWAP B\n");
        sb.append("JZERO -4\n");
        sb.append("JUMP 1\n");

        String command = "ADD";
        String iteration = "DEC";

        if(var1.getValue() > 0 && var2.getValue() < 0
        || var1.getValue() < 0 && var2.getValue() > 0)
        {
            command = "SUB";
        }

        if(var2.getValue() < 0)
        {
            iteration = "INC";
        }

        sb.append("SWAP B\n");
        sb.append(command).append(" A\n");
        sb.append(iteration).append(" B\n");
        sb.append("SWAP B\n");
        sb.append("JZERO -4\n");
        offset+=5;

    }

    /**
     * Writes division operation to code, res in reg A
     */
    void div(Variable var1, Variable var2)
    {
        sb.append("(START DIV)\n");
        getVarValInAB(var1, var2);
        sb.append("RESET C\n");

        sb.append("JZERO 35\n");
        sb.append("SWAP B\n"); //SWAP Bval -> Areg
        sb.append("JZERO 33\n");
        sb.append("SWAP B\n"); //SWAP Aval -> Areg
        sb.append("JPOS 4\n"); //JUMP TO IF A > 0
        sb.append("SWAP B\n"); //SWAP Bval -> Areg
        sb.append("JPOS 24\n"); //JUMP TO IF A < 0 & B > 0
        sb.append("JNEG 16\n"); //JUMP TO IF A < 0 & B < 0
        sb.append("SWAP B\n");  // SWAP Bval -> Areg
        sb.append("JPOS 7\n"); //JUMP TO IF A > 0 & B > 0
        //Code If A > 0 & B < 0
        sb.append("SWAP B\n");  //SWAP Aval -> Areg
        sb.append("ADD B\n");
        sb.append("DEC C\n");
        sb.append("JPOS -2\n");
        sb.append("SWAP C\n");
        sb.append("JUMP 20\n");
        //Code If A > 0 & B > 0
        sb.append("SWAP B\n");
        sb.append("SUB B\n");
        sb.append("JNEG 3\n");
        sb.append("INC C\n");
        sb.append("JPOS -3\n");
        sb.append("SWAP C\n");
        sb.append("JUMP 13\n");
        //Code If A < 0 & B < 0
        sb.append("SWAP B\n");
        sb.append("SUB B\n");
        sb.append("JPOS 3\n");
        sb.append("INC C\n");
        sb.append("JNEG -3\n");
        sb.append("SWAP C\n");
        sb.append("JUMP 6\n");
        //Code If A < 0 & B > 0
        sb.append("SWAP B\n");
        sb.append("ADD B\n");
        sb.append("DEC C\n");
        sb.append("JNEG -2\n");
        sb.append("SWAP C\n");
        sb.append("JUMP 1\n");

    }

    /**
     * Writes modulo operation to code, res in reg A
     */
    void mod(Variable var1, Variable var2)
    {
        sb.append("(START MOD)\n");
        getVarValInAB(var1, var2);
        sb.append("RESET C\n");

        sb.append("JZERO 29\n");
        sb.append("SWAP B\n"); //SWAP Bval -> Areg
        sb.append("JZERO 27\n");
        sb.append("SWAP B\n"); //SWAP Aval -> Areg
        sb.append("JPOS 4\n"); //JUMP TO IF A > 0
        sb.append("SWAP B\n"); //SWAP Bval -> Areg
        sb.append("JPOS 20\n"); //JUMP TO IF A < 0 & B > 0
        sb.append("JNEG 13\n"); //JUMP TO IF A < 0 & B < 0
        sb.append("SWAP B\n");  // SWAP Bval -> Areg
        sb.append("JPOS 5\n"); //JUMP TO IF A > 0 & B > 0
        //Code If A > 0 & B < 0
        sb.append("SWAP B\n");  //SWAP Aval -> Areg
        sb.append("ADD B\n");
        sb.append("JPOS -2\n");
        sb.append("JUMP 16\n");
        //Code If A > 0 & B > 0
        sb.append("SWAP B\n");
        sb.append("SUB B\n");
        sb.append("JNEG 3\n");
        sb.append("JPOS -3\n");
        sb.append("ADD B\n");
        sb.append("JUMP 10\n");
        //Code If A < 0 & B < 0
        sb.append("SWAP B\n");
        sb.append("SUB B\n");
        sb.append("JPOS 3\n");
        sb.append("JNEG -3\n");
        sb.append("ADD B\n");
        sb.append("JUMP 4\n");
        //Code If A < 0 & B > 0
        sb.append("SWAP B\n");
        sb.append("ADD B\n");
        sb.append("JNEG -2\n");
        sb.append("JUMP 1\n");

    }
}
