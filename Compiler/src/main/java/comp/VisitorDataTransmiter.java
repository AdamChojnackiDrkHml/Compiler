package comp;

import java.util.ArrayList;

public class VisitorDataTransmiter {
    Variable variable = null;
    ArrayList<String> codeHandler = new ArrayList<>();
    long offset = 0;

    public VisitorDataTransmiter(Variable var)
    {
        variable = var;
    }


    public VisitorDataTransmiter()
    {
        codeHandler = new ArrayList<>();
    }
}
