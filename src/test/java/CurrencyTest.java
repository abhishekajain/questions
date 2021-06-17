import org.junit.Assert;
import org.junit.Test;

public class CurrencyTest {

    @Test
    public void testDollorCents(){
        Assert.assertFalse(Currency.isCurrency("$01.45"));
        Assert.assertTrue(Currency.isCurrency("$00.45"));
        Assert.assertFalse(Currency.isCurrency("$0100.45"));
        Assert.assertTrue(Currency.isCurrency("$0.45"));
    }

    @Test
    public void testDollors(){
        Assert.assertTrue(Currency.isCurrency("$100,000.45"));
        Assert.assertTrue(Currency.isCurrency("$100"));
        Assert.assertTrue(Currency.isCurrency("-$100.45"));
        Assert.assertTrue(Currency.isCurrency("($0.45)"));
    }

}
