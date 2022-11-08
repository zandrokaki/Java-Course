package Calculator;

public class Divide extends Operator {

    public Divide()
    {
        this.op1 = 0;
        this.op2 = 0;
    }

    public Divide(int x, int y)
    {
       this.op1 = x;
       this.op2 = y;
    }

    public double operate()
    {
        return operate(this.op1, this.op2);
    }

    public double operate(int x, int y)
    {
        int result = 0;

        try{
            result = x/y;
        }catch(ArithmeticException e)
        {
            System.out.println("Error: Division by zero");
        }

        return result;
    }
}
