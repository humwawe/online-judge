package codeforces.c768;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BFunWithEvenSubarrays {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int i = n - 1;
        int res = 0;
        while (i >= 0) {
            int j = i;
            while (j - 1 >= 0 && a[j - 1] == a[n - 1]) {
                j--;
            }
            if (j == 0) {
                break;
            }
            i = n - (2 * (n - j));
            res++;
        }
        out.println(res);
    }
}
