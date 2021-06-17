import org.junit.Assert;
import org.junit.Test;

public class ParenthesesUtilTest {

    @Test
    public void testminRemoveToMakeValid(){
        Assert.assertEquals("lee(t(c)o)de", ParenthesesUtil.minRemoveToMakeValid("lee(t(c)o)de)"));
        Assert.assertEquals("ab(c)d", ParenthesesUtil.minRemoveToMakeValid("a)b(c)d"));
        Assert.assertEquals("", ParenthesesUtil.minRemoveToMakeValid("))(("));
        Assert.assertEquals("a(b(c)d)", ParenthesesUtil.minRemoveToMakeValid("(a(b(c)d)"));
    }

    @Test
    public void testisValidParenthese(){
        Assert.assertFalse(ParenthesesUtil.isValidParenthese("lee(t(c)o)de)"));
        Assert.assertFalse( ParenthesesUtil.isValidParenthese("a)b(c)d"));
        Assert.assertFalse(ParenthesesUtil.isValidParenthese("))(("));
        Assert.assertFalse(ParenthesesUtil.isValidParenthese("(a(b(c)d)"));
        Assert.assertTrue(ParenthesesUtil.isValidParenthese("a(b(c)d)"));
        Assert.assertTrue(ParenthesesUtil.isValidParenthese("(ab(c)d)"));
        Assert.assertTrue(ParenthesesUtil.isValidParenthese("lee(t(c)o)de"));
        Assert.assertTrue(ParenthesesUtil.isValidParenthese(""));
        Assert.assertTrue(ParenthesesUtil.isValidParenthese("ab(c)d"));

    }
}
