package comp;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

import static comp.Registers.A;
import static comp.Registers.B;

public class CodeGenerator
{
    ArrayList<String> wholeCodeBuilder = new ArrayList<>();
    DataHandler dh;


    void writeEnd() {
        wholeCodeBuilder.add("HALT\n");
    }

    void writeCode(String path) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(System.getProperty("user.dir") + path), StandardCharsets.UTF_8))) {
            writer.write(wholeCodeBuilder.toString());
        }
    }

    void addSingle(String op)
    {
        wholeCodeBuilder.add(op);
    }

    /**
     * Writes wanted constant to given register.
     * Use registers A and B
     * ALL PREV DATA WILL BE LOST
     */
    public long genConst(long con, Registers reg, ArrayList<String> sb)
    {
        long offset = 0;
        sb.add("RESET a\n");
        sb.add("RESET b\n");
        sb.add("INC b\n");
        offset+=3;
        String bo = Long.toBinaryString(con);
        char[] bits = bo.toCharArray();
        for(char bit : bits)
        {
            if(bit == '1')
            {
                sb.add("SHIFT b\n");
                sb.add("INC a\n");
                offset+=2;
            }
            else
            {
                sb.add("SHIFT b\n");
                offset++;
            }
        }
        sb.add("SWAP " + reg.toString().toLowerCase(Locale.ROOT) + "\n");
        offset++;

        return offset;

    }

    /**
     * Saves value from register to mem.
     */
    long saveRegToMem(Variable var, Registers r, ArrayList<String> sb)
    {
        long offset = 0;
        boolean isArr = var.getArrayAddress() != -1;
        switch (r) {
            case A -> {
                sb.add("(START SAVING)\n");
                sb.add("SWAP c\n");
                offset += getMemAddrInRegA(var, sb, isArr);
                //sb.add("PUT\n");
                if(var.getArrayAddress() != -1)
                {
                    sb.add("SWAP d\n");
                    offset += genConst(var.getArrayAddress()-var., A, sb);
                    sb.add("(POSITION ADDRES GENERATED)\n");
                    sb.add("LOAD a\n");
                    //sb.add("PUT\n");
                    sb.add("ADD d\n");
                    sb.add("PUT\n");
                }
                sb.add("SWAP c\n");
                //sb.add("PUT");
                sb.add("STORE c\n");
                offset += 3;
            }
            case B -> {
                sb.add("SWAP c\n");
                sb.add("SWAP c\n");
                offset += getMemAddrInRegA(var, sb, isArr);
                sb.add("SWAP c\n");
                sb.add("STORE c\n");
                offset += 4;
            }
            default -> {
                offset += getMemAddrInRegA(var, sb, isArr);
                sb.add("SWAP " + r.toString().toLowerCase(Locale.ROOT) +"\n");
                sb.add("STORE " + r.toString().toLowerCase(Locale.ROOT) + "\n");
                offset += 2;
            }
        }

        return offset;
    }

    long getMemFromReg(Variable var, Registers r, ArrayList<String> sb, boolean isArr)
    {
        long offset = 0;
        offset += getMemAddrInRegA(var, sb, false);
        if(isArr)
        {
            sb.add("PUT\n");
            sb.add("SWAP d\n");
            offset += genConst(var.getArrayAddress(), A, sb);
            sb.add("PUT\n");
            sb.add("ADD d");
            offset++;

        }
        sb.add("LOAD a\n");
        sb.add("SWAP " + r.toString().toLowerCase(Locale.ROOT) + "\n");
        offset += 2;
        return offset;
    }

    long getVarVal(Variable var, Registers r, ArrayList<String> sb)
    {
        long offset = 0;
        if(!var.isSet())
        {
            offset += genConst(var.getValue(), r, sb);
        }
        else if(var.getArrayAddress() != -1)
        {
            offset += getMemFromReg(var, r, sb, true);
        }
        else
        {
            offset += getMemFromReg(var, r, sb, false);
        }
        return offset;
    }

    long getVarValInAB(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        offset += getVarVal(var1, A, sb);
        sb.add("SWAP c\n");
        offset += getVarVal(var2, B, sb);
        sb.add("SWAP c\n");
        offset += 2;
        return offset;
    }

    long getMemAddrInRegA(Variable var, ArrayList<String> sb, boolean isArr)
    {
        long addr = var.getAddress();
        //sb.add("START GENERATING ADDR IN REG A\n");
        return genConst(addr, A, sb);
    }

    void arrayOffset(long addres, long offset)
    {
    }

    //
    //IO//
    //
    long read(Variable var, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START READ)\n");
        sb.add("GET\n");
        offset += 1;
        offset += saveRegToMem(var, A, sb);

        var.setSet(true);
        return offset;
    }

    long write(Variable var, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START WRITE)\n");
        offset += getVarVal(var, A, sb);
        sb.add("PUT\n");
        offset++;
        return offset;
    }

    //
    //ASSIGN//
    //
    long assign(Variable var, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START ASSIGN)\n");
        return saveRegToMem(var, A, sb);
    }


    //
    //OPERATIONS//
    //

    long getConstant(Variable var, ArrayList<String> sb)
    {
        return getVarVal(var, A, sb);
    }

    long add(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START ADD)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("ADD b\n");
        offset++;
        return offset;
    }

    long sub(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START SUB)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("SUB b\n");
        offset++;
        return offset;
    }

    long mul(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START MUL)\n");

        offset += getVarValInAB(var1, var2, sb);
//        sb.add("PUT\n");
//        sb.add("SWAP b");
//        sb.add("PUT\n");
//        sb.add("SWAP b");

        sb.add("JZERO 37\n"); //JUMP IF VAR1 0
        sb.add("SWAP b\n");
        sb.add("JZERO 35\n"); //JUMP IF VAR2 0
        sb.add("SWAP b\n");

        sb.add("SWAP c\n");
        sb.add("RESET a\n");
        sb.add("JPOS 4\n"); //JUMP TO IF A > 0
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JPOS 22\n"); //JUMP TO IF A < 0 & B > 0
        sb.add("JNEG 15\n"); //JUMP TO IF A < 0 & B < 0
        sb.add("SWAP b\n");  // SWAP Bval -> Areg
        sb.add("JPOS 7\n"); //JUMP TO IF A > 0 & B > 0

        //Code If A > 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB c\n");
        sb.add("INC b\n");
        sb.add("SWAP b\n");
        sb.add("JNEG -4\n");
        sb.add("JUMP 18\n");

        //Code If A > 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD c\n");
        sb.add("DEC b\n");
        sb.add("SWAP b\n");
        sb.add("JPOS -4\n");
        sb.add("JUMP 12\n");

        //Code If A < 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB c\n");
        sb.add("INC b\n");
        sb.add("SWAP b\n");
        sb.add("JNEG -4\n");
        sb.add("JUMP 6\n");

        //Code If A < 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD c\n");
        sb.add("DEC b\n");
        sb.add("SWAP b\n");
        sb.add("JPOS -4\n");
        sb.add("JUMP 1\n");
        sb.add("SWAP b\n");

        offset += 36;
        return offset;
    }

    /**
     * Writes division operation to code, res in reg A
     */
    long div(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START DIV)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("RESET c\n");

        sb.add("JZERO 35\n");
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JZERO 33\n");
        sb.add("SWAP b\n"); //SWAP Aval -> Areg
        sb.add("JPOS 4\n"); //JUMP TO IF A > 0
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JPOS 24\n"); //JUMP TO IF A < 0 & B > 0
        sb.add("JNEG 16\n"); //JUMP TO IF A < 0 & B < 0
        sb.add("SWAP b\n");  // SWAP Bval -> Areg
        sb.add("JPOS 7\n"); //JUMP TO IF A > 0 & B > 0
        //Code If A > 0 & B < 0
        sb.add("SWAP b\n");  //SWAP Aval -> Areg
        sb.add("ADD b\n");
        sb.add("DEC c\n");
        sb.add("JPOS -2\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 20\n");
        //Code If A > 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JNEG 3\n");
        sb.add("INC c\n");
        sb.add("JPOS -3\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 13\n");
        //Code If A < 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JPOS 3\n");
        sb.add("INC c\n");
        sb.add("JNEG -3\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 6\n");
        //Code If A < 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD b\n");
        sb.add("DEC c\n");
        sb.add("JNEG -2\n");
        sb.add("SWAP c\n");
        sb.add("JUMP 1\n");
        offset += 37;
        return offset;
    }

    /**
     * Writes modulo operation to code, res in reg A
     */
    long mod(Variable var1, Variable var2, ArrayList<String> sb)
    {
        long offset = 0;
        //sb.add("(START MOD)\n");
        offset += getVarValInAB(var1, var2, sb);
        sb.add("RESET c\n");



        sb.add("JZERO 29\n");
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JZERO 27\n");
        sb.add("SWAP b\n"); //SWAP Aval -> Areg
        sb.add("JPOS 4\n"); //JUMP TO IF A > 0
        sb.add("SWAP b\n"); //SWAP Bval -> Areg
        sb.add("JPOS 20\n"); //JUMP TO IF A < 0 & B > 0
        sb.add("JNEG 13\n"); //JUMP TO IF A < 0 & B < 0
        sb.add("SWAP b\n");  // SWAP Bval -> Areg
        sb.add("JPOS 5\n"); //JUMP TO IF A > 0 & B > 0
        //Code If A > 0 & B < 0
        sb.add("SWAP b\n");  //SWAP Aval -> Areg
        sb.add("ADD b\n");
        sb.add("JPOS -1\n");
        sb.add("JUMP 16\n");
        //Code If A > 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JPOS -1\n");
        sb.add("JZERO 2\n");
        sb.add("ADD b\n");
        sb.add("JUMP 10\n");
        //Code If A < 0 & B < 0
        sb.add("SWAP b\n");
        sb.add("SUB b\n");
        sb.add("JNEG -1\n");
        sb.add("JZERO 2\n");
        sb.add("ADD b\n");
        sb.add("JUMP 4\n");
        //Code If A < 0 & B > 0
        sb.add("SWAP b\n");
        sb.add("ADD b\n");
        sb.add("JNEG -1\n");
        sb.add("JUMP 1\n");
        offset += 31;
        return offset;
    }


    //
    //COMPARATIVES
    //

    CondLabel eqBeg(Variable var1, Variable var2)
    {
        CondLabel cL = new CondLabel();

        getVarValInAB(var1, var2, cL.condPreAmbule);
        cL.condPreAmbule.add("SUB B\n");
        cL.condPreAmbule.add("JZERO 2\n"); //FIX JUMP if TRUE
        //sb.append("JUMP indef\n"); //FIX JUMP IF FALSE

        return cL;
    }




    //
    //IFs
    //

    void if_block(long go_to, StringBuilder sb)
    {

    }
}
