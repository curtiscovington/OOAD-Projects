package hw4.test;
import hw4.CashRegister;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class CashRegisterTest {

    private CashRegister cashRegister;

    @Before
    public void setUp() throws Exception {
        cashRegister = new CashRegister(50.00);
    }

    @Test
    public void testdeposit() {
        cashRegister.deposit(100);
        cashRegister.deposit(50);
        Assert.assertEquals(200, cashRegister.getTotal(), 0.00);
        Assert.assertEquals(50, cashRegister.withdraw(50), 0.00);
        Assert.assertEquals(150, cashRegister.getTotal(), 0.00);
        Assert.assertEquals(150, cashRegister.withdraw(300), 0.00);
        Assert.assertEquals(0, cashRegister.getTotal(), 0.00);
        Assert.assertEquals(0, cashRegister.withdraw(50), 0.00);

    }
}
