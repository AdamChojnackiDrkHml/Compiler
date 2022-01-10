package comp;

public class ForLabel
{
    private final Variable iterator;
    private final Variable start;
    private final Variable end;
    private CondLabel condLabel;
    private final Variable skip;

    ForLabel(Variable iterator, Variable start, Variable end, Variable skip)
    {
        this.iterator = iterator;
        this.start = start;
        this.end = end;
        this.skip = skip;
    }

    public Variable getIterator()
    {
        return iterator;
    }

    public Variable getStart()
    {
        return start;
    }

    public Variable getEnd()
    {
        return end;
    }

    public Variable getSkip()
    {
        return skip;
    }

    public CondLabel getCondLabel()
    {
        return condLabel;
    }

    public void setCondLabel(CondLabel condLabel)
    {
        this.condLabel = condLabel;
    }
}
