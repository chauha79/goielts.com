package hashTable;

import java.util.Hashtable;
import java.util.Random;

public class HashTable {
    public static void main(String[] args) {
        Hashtable<Integer, String> hashTable = new Hashtable<>();
        int n = 10;
        long avgTime = 0;
        // time for each insertion
        for (int i = 0; i < n; i++) {
            String rs = randomString(n);
            long start = System.nanoTime();
            hashTable.put(i, rs);
            System.out.println("Generated String:" + rs);
            long end = System.nanoTime();
            avgTime = +(end - start);
        }
        System.out.println("Average time for each insertion: " + avgTime / n +
                " nanoseconds");
        for (int i = 0; i < n; i++) {
            String rs = randomString(n);
            long start = System.nanoTime();
            if (hashTable.get(i) == rs) {
                long end = System.nanoTime();
                long time = (end - start) / n;
                System.out.println("Founded String is " + rs + " nanoseconds");
                System.out.println("Average time for search " + time + " nanoseconds");
                hashTable.remove(i);
            }
        }
    }

    public static String randomString(int len) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            int in = random.nextInt(letters.length());
            char rc = letters.charAt(in);
            sb.append(rc);
        }
        return sb.toString();
    }

}