import org.junit.Test;

import java.time.Instant;

/**
 * @author quinn
 * @create 2021-01-31 11:41
 */

public class MyTest {
    @Test
    public void test1() {
        long startTime = 0L;
        long endTime = 0L;

        String s1 = new String("");
        StringBuffer s2 = new StringBuffer("");
        StringBuilder s3 = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            s3.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            s2.append(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 50000; i++) {
            s1 += i;
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    @Test
    public void test2() {
        Instant instant = Instant.ofEpochMilli(1236666987692L);
        System.out.println(instant);
    }
}
