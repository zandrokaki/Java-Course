import static org.junit.Assert.assertEquals;


import org.junit.Test;

public class MainTest {
    @Test
    public void sellTest()
    {
        Machine machine = new Machine();
        Product exPp = new Product("Plumbu", 2.0);
        
        Product myProduct = machine.sellProduct(4.0, exPp);

        assertEquals(exPp.getName(), myProduct.getName());
    }
   
    @Test
    public void findTest() throws Exception
    {
        Machine machine = new Machine();
        Product p = new Product("Plumbu", 2.0);
        int expS = 2;
        int stock = machine.findProduct(p);

        assertEquals(expS, stock);
    }

   

    


}
