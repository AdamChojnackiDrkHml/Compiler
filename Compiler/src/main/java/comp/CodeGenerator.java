package comp;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class CodeGenerator
{
    StringBuilder sb = new StringBuilder();
    DataHandler dh;
    private long offset = 0;

    void writeEnd() {
        sb.append("\nHALT");
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

    void saveRegToMem(Variable var, Registers r)
    {
        if (r == Registers.A)
        {
            sb.append("SWAP B\n");
            getMemAddInRegA(var);
            sb.append("SWAP B\n");
            sb.append("STORE B\n");
            offset+=3;
        }
        else
        {
            getMemAddInRegA(var);
            sb.append("SWAP ").append(r).append("\n");
            sb.append("STORE ").append(r).append("\n");
            offset+=2;
        }
    }

    void getMemFromReg(Variable var, Registers r)
    {
        getMemAddInRegA(var);
        sb.append("LOAD A\nSWAP ").append(r).append("\n");
        offset+=2;
    }

    void getVarVal(Variable var, Registers r)
    {
        if(var.isSet())
        {
            genConst(var.getAddress(), r);
        }
        else
        {
            getMemFromReg(var, r);
        }
    }

    void getMemAddInRegA(Variable var)
    {
        genConst(var.getAddress(), Registers.A);
    }

    void arrayOffset(long addres, long offset)
    {
    }


    //OPERATIONS//
    void getConstant(Variable var)
    {
        getVarVal(var, Registers.B);
    }

    void add(Variable var1, Variable var2)
    {
        getVarVal(var1, Registers.A);
        getVarVal(var2, Registers.B);
        sb.append("ADD B\n");
        offset++;
    }

    void sub(Variable var1, Variable var2)
    {
        getVarVal(var1, Registers.A);
        getVarVal(var2, Registers.B);
        sb.append("SUB B\n");
        offset++;
    }

    void mul(Variable var1, Variable var2)
    {
        if(var1.getValue() == 0 || var2.getValue() == 0)
        {
            sb.append("RESET A\n");
            offset++;
            return;
        }

        getVarVal(var1, Registers.C);
        getVarVal(var2, Registers.B);
        sb.append("SWAP B\n");


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

    void div(Variable var1, Variable var2)
    {
        if(var1.getValue() == 0)
        {
            sb.append("RESET A\n");
            offset++;
        }

        getVarVal(var1, Registers.A);
        getVarVal(var2, Registers.B);
        sb.append("RESET C\n");
        offset++;
        String command = "SUB";
        String iteration = "DEC";
        String compare = var1.getValue() > 0 ? "JNEG" : "JPOS";
        String anticompare = var1.getValue() < 0 ? "JNEG" : "JPOS";

        if(var1.getValue() > 0 && var2.getValue() < 0
                || var1.getValue() < 0 && var2.getValue() > 0)
        {
            iteration = "DEC";
            command = "ADD";
        }

        sb.append(command).append(" B\n");
        sb.append(compare).append(" 3\n");
        sb.append(iteration).append(" C\n");
        sb.append(anticompare).append(" -3\n");
        sb.append("SWAP C\n");
        offset+=5;
    }

    void mod(Variable var1, Variable var2)
    {

    }
}
