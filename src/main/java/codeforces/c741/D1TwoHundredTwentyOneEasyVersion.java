package codeforces.c741;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D1TwoHundredTwentyOneEasyVersion {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int q = in.nextInt();
        int[] sum = new int[n + 1];
        int sign = 1;
        for (int i = 0; i < n; i++) {
            int c = in.nextCharacter();
            if (c == '+') {
                sum[i + 1] = sum[i] + sign;
            } else {
                sum[i + 1] = sum[i] - sign;
            }
            sign *= -1;
        }

        for (int i = 0; i < q; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            int t = Math.abs(sum[r] - sum[l - 1]);
            if (t == 0) {
                out.println(0);
            } else {
                if (t % 2 == 1) {
                    out.println(1);
                } else {
                    out.println(2);
                }
            }
        }
    }


}
