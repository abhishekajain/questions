import org.junit.Assert;
import org.junit.Test;

public class QueryOfQueriesTest {

    @Test
    public void test(){
        int[] expected = {8,6,2,4};
        QueryOfQueries query = new QueryOfQueries();
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        Assert.assertArrayEquals(expected, query.sumEvenAfterQueries(A, queries));
    }
}
