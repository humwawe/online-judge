package codeforces.c731;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DCoGrowingSequence {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[n];
        int last = 0;
        for (int i = 0; i < 31; i++) {
            if (((a[0] >> i) & 1) == 1) {
                last |= 1 << i;
            }
        }
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = 0; j < 31; j++) {
                if (((last >> j) & 1) == 1 && ((a[i] >> j) & 1) == 0) {
                    tmp |= 1 << j;
                }
            }
            b[i] = tmp;
            last = a[i] ^ b[i];
        }
        out.println(b);
    }
}
