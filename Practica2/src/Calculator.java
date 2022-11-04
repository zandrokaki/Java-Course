public class Calculator {
    private int op1;
    private int op2;

    public Calculator()
    {
        op1 = 0;
        op2 = 0;
    }
    
    public int operate(int op1, int op2, char op)
    {
        int result = 0;

        switch(op){
            case '+':
                result = add(op1, op2);
                break;
            
            case '-':
                result = subtract(op1, op2);
                break;

            case '*':
                result = multiply(op1, op2);
                 break;

            case '/':
                result = divide(op1, op2);
                break;

            default:
                System.out.println("Enter a valid operation ( +, -, *, / )");
        }

        return result;
    }

    public int add(int op1, int op2)
    {
        return op1+op2;
    }

    public int subtract(int op1, int op2)
    {
        return op1-op2;
    }

    public int multiply(int op1, int op2)
    {
        return op1*op2;
    }

    public int divide(int op1, int op2)
    {
       int result=0;

       try{
            result = op1/op2;
       }catch(Exception e)
       {
        System.out.println("Error: Dividing by zero");
       }

       return result;
    }



    
}
