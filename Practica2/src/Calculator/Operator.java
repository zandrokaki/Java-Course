package Calculator;

public abstract class Operator {
    protected int op1;
    protected int op2;

    public abstract double operate(int x, int y);
}
