package Calculator;

public class Multiply extends Operator {
    
    public Multiply()
    {
        this.op1 = 0;
        this.op2 = 0;
    }

    public Multiply(int x, int y)
    {
        this.op1 = x;
        this.op2 = y;
    }

    public double operate()
    {
        return operate(op1, op2);
    }

    public double operate(int x, int y)
    {
        return x*y;
    }
}
