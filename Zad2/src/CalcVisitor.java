import gen.zad2BaseVisitor;
import gen.zad2Parser;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CalcVisitor extends zad2BaseVisitor<Integer>
{
    ArrayList<String> reversPolishNotation = new ArrayList<>();
    final int N = 1234577;

    int converge(int a, int N)
    {
        if(a > 0)
        {
            return a % N;
        }

        while(a < 0)
        {
            a += N;
        }

        return a;
    }

    int add(int a, int b, int N)
    {
        return a+b <N ? a+b : a+b - N;
    }

    int substract(int a, int b, int N)
    {
        return converge(a - b, N);
    }

    int power(int a, int pow, int N)
    {
        System.out.println(a + " " + pow + " " + N);
        if (pow == 0)

            return 1;

        long b = power(a, pow/2, N);

        if (pow % 2 == 0)
        {
            System.out.println((b * b) % N + " a");
            return (int)((b * b) % N);
        }
        else
        {
            System.out.println((a * b * b) % N + " b");
            return (int)((a * b * b) % N);
        }
    }

    int multiply(int a, int b, int N)
    {
        return (a * b) % N;
    }

    int neg(int a, int N)
    {
        return a > 0 ? -a + N : a;
    }

    // Function to find modulo inverse of b. It returns
// -1 when inverse doesn't
    int modInverse(int b, int m)
    {
        AtomicInteger _x = new AtomicInteger(), _y = new AtomicInteger();
        int g = gcdExtended(b, m, _x, _y);

        // Return -1 if b and m are not co-prime
        if (g != 1)
            return -1;

        // m is added to handle negative x
        return (_x.get()%m + m) % m;
    }

    // Function to compute a/b under modulo m
    int divide(int a, int b, int N)
    {
        a = a % N;
        int inv = modInverse(b, N);
        if (inv == -1)
            return -1;
        else
        {
            return (inv * a) % N;
        }
    }

    // C function for extended Euclidean Algorithm (used to
// find modular inverse.
    public static int gcdExtended(int a, int b, AtomicInteger x, AtomicInteger y)
    {
        if (a == 0)
        {
            x.set(0);
            y.set(1);
            return b;
        }

        AtomicInteger _x = new AtomicInteger(), _y = new AtomicInteger();
        int gcd = gcdExtended(b % a, a, _x, _y);

        x.set(_y.get() - (b/a) * _x.get());
        y.set(_x.get());

        return gcd;
    }


    @Override
    public Integer visitPrint(zad2Parser.PrintContext ctx) {
        Integer value = visit(ctx.expression());

        for(int i = 0; i < reversPolishNotation.size(); i++)
        {
            System.out.print(reversPolishNotation.get(reversPolishNotation.size() - i - 1));
        }

        System.out.println("\n" + value);
        return value;
    }


    @Override
    public Integer visitNumer(zad2Parser.NumerContext ctx) {
        int res = Integer.parseInt(ctx.NUMBER().getText());
        if(ctx.operator != null)
        {

            res = neg(res, N);
        }
        else
        {
            res = converge(res, N-1);
        }
        reversPolishNotation.add(" " + res + " ");
        return res;
    }

    @Override
    public Integer visitParentheses(zad2Parser.ParenthesesContext ctx) {
        return this.visit(ctx.inner);
    }



    @Override
    public Integer visitAddSub(zad2Parser.AddSubContext ctx)
    {
        if(ctx.operator == null)
        {
            return this.visit(ctx.left);
        }
        if (ctx.operator.getText().equals("+"))
        {
            reversPolishNotation.add(" + ");
            return add(this.visit(ctx.left), this.visit(ctx.right), N);
        }
        reversPolishNotation.add(" - ");
        return substract(this.visit(ctx.left), this.visit(ctx.right), N);
    }

    @Override
    public Integer visitMulDiv(zad2Parser.MulDivContext ctx)
    {
        if(ctx.operator == null)
        {
            return this.visit(ctx.left);
        }
        if (ctx.operator.getText().equals("*"))
        {
            reversPolishNotation.add(" * ");
            return multiply(this.visit(ctx.left), this.visit(ctx.right), N);
        }

        if(this.visit(ctx.right) == 0)
        {
            System.exit(0);
        }

        reversPolishNotation.add(" / ");
        return divide(this.visit(ctx.left), this.visit(ctx.right), N);


    }

    @Override
    public Integer visitPwr(zad2Parser.PwrContext ctx)
    {
        if(ctx.operator == null)
        {
            return this.visit(ctx.left);
        }
        reversPolishNotation.add    (" ^ ");
        return power(this.visit(ctx.left), this.visit(ctx.right), N);
    }

    @Override
    public Integer visitAPwrNumer(zad2Parser.APwrNumerContext ctx) {
        int res = Integer.parseInt(ctx.NUMBER().getText());
        if(ctx.operator != null)
        {

            res = neg(res, N-1);
        }
        else
        {
            res = converge(res, N-1);
        }
        reversPolishNotation.add(" " + res + " ");
        return res;
    }

    @Override
    public Integer visitAPwrParentheses(zad2Parser.APwrParenthesesContext ctx) {
        return this.visit(ctx.inner);
    }



    @Override
    public Integer visitAPwrAddSub(zad2Parser.APwrAddSubContext ctx)
    {
        if(ctx.operator == null)
        {
            return this.visit(ctx.left);
        }
        if (ctx.operator.getText().equals("+"))
        {
            reversPolishNotation.add(" + ");
            return add(this.visit(ctx.left), this.visit(ctx.right), N-1);
        }
        reversPolishNotation.add(" - ");
        return substract(this.visit(ctx.left), this.visit(ctx.right), N-1);
    }

    @Override
    public Integer visitAPwrMulDiv(zad2Parser.APwrMulDivContext ctx)
    {
        if(ctx.operator == null)
        {
            return this.visit(ctx.left);
        }
        if (ctx.operator.getText().equals("*"))
        {
            reversPolishNotation.add(" * ");
            return multiply(this.visit(ctx.left), this.visit(ctx.right), N-1);
        }

        if(this.visit(ctx.right) == 0)
        {
            System.exit(0);
        }

        reversPolishNotation.add(" / ");
        return divide(this.visit(ctx.left), this.visit(ctx.right), N-1);


    }
}
