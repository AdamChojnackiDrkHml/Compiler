package comp;

public class Variable
{
    private final long address;
    private final long arrayAddress;
    long arrayOffset;
    private long value;
    private boolean isSet;
    Symbol symbol;

    public Variable(long address)
    {
        this.address = address;
        arrayAddress = -1;
        isSet = true;
    }

    public Variable(long address, long arrayAddress)
    {
        this.address = address;
        this.arrayAddress = arrayAddress;
        isSet = false;
    }

    public Variable(long address, long arrayAddress, long value)
    {
        this.address = address;
        this.arrayAddress = arrayAddress;
        this.value = value;
    }

    public long getArrayAddress()
    {
        return arrayAddress;
    }

    public long getAddress()
    {
        return address;
    }

    public long getValue()
    {
        return value;
    }

    public void setValue(long value)
    {
        this.value = value;
    }

    public boolean isSet() {
        return isSet;
    }

    public void setSet(boolean set) {
        isSet = set;
    }
}
