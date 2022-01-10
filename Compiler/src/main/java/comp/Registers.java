package comp;

public enum Registers
{
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H;

    public Registers fromString(String s)
    {
        switch(s) {
            case "A": return A;
            case "B": return B;
            case "C": return C;
            case "D": return D;
            case "E": return E;
            case "F": return F;
            case "G": return G;
            case "H": return H;
        }
        return A;
    }
}
