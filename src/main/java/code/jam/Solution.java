package code.jam;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * @author hum
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();
        int no = 1;
        String result = "Case #%d: %s %s";
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            for (char c : s.toCharArray()) {
                Integer tmp = c - '0';
                if (tmp == 4) {
                    stringBuilder1.append(2);
                    stringBuilder2.append(2);
                } else {
                    stringBuilder1.append(tmp);
                    if (stringBuilder2.length() != 0) {
                        stringBuilder2.append(0);
                    }
                }
            }
            System.out.println(String.format(result, no++, stringBuilder1.toString(), stringBuilder2.toString()));
        }
    }
}
