/**
 * @author quinn
 * @create 2021-01-31 11:41
 */
public class Test {
    public static void main(String[] args) {
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
}
