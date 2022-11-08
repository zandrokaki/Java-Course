package Calculator;

public class Subtract extends Operator {
    
    public Subtract()
    {
        this.op1 = 0;
        this.op2 = 0;
    }

    public Subtract(int x, int y)
    {
        this.op1 = x;
        this.op2 = y;
    }

    public double operate()
    {
        return operate(op2, op1);
    }

    public double operate(int x, int y)
    {
        return x-y;
    }
}

