package Calculator;

public class Add extends Operator {
    
    public Add()
    {
        this.op1 = 0;
        this.op2 = 0;
    }

    public Add(int x, int y)
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
        return x+y;
    }
}
