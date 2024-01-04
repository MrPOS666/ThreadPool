package ruitao.threadPool;

import org.junit.Assert;

import org.junit.Test;

import java.util.Arrays;

/**
 * Unit test for simple App.
 */
public class TPTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void ThreadPoolTest() {
        ThreadPoolExcutor pool = new ThreadPoolExcutor(3, 3);
        Customer[] l = {new Customer("Alice"), new Customer("Bob"),
                new Customer("Cathrine"), new Customer("Dave"),
                new Customer("Eve"), new Customer("Frank")};
        System.out.println(Arrays.toString(l));
        for (int i = 0; i < l.length; i++) {
            pool.execute(l[i]);
        }
        pool.shutdown();
        Assert.assertTrue(true);
    }
}
