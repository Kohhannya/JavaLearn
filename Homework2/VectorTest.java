package Homework2;

import org.junit.Assert;
import org.junit.Test;

public class VectorTest {
    @Test
    public void testVector() throws Exception {
        Vector a = new Vector(1.00001, 0.00001, 0);
        Vector b = new Vector(0, 3, 0);

        Assert.assertTrue(a.equals(new Vector(1, 0, 0)));
        Assert.assertFalse(a.equals(b));
        Assert.assertEquals(a.equals(new Vector(0, 0,0)), false);

        assert(b.length()== 3);
        assert(a.scalarProduct(b)== 3.0000000000000004E-5);
        Assert.assertEquals(a.crossProduct(b), new Vector(0, 0, 3));

        Assert.assertTrue(a.add(b).equals(new Vector(1.0, 3.0, 0.0)));
        Assert.assertFalse(a.subtract(b) == new Vector(1, -3, 0));

        assert(a.hashCode() == 10000000);
        assert(b.hashCode() == 300000);
    }
}
