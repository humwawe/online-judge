package code.jam;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        String result = "Case #%d: %s %s %d";
        for (int cas = 1; cas <= n; cas++) {
            String res = "";
            System.out.println(String.format(result, cas, res));
        }
    }
}
