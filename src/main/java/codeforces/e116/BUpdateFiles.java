package codeforces.e116;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BUpdateFiles {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.nextLong();
        long k = in.nextLong();
        long tmp = 1;
        long res = 0;
        while (tmp < k) {
            tmp <<= 1;
            res++;
        }
        if (n <= tmp) {
            res = 0;
            tmp = 1;
            while (tmp < n) {
                tmp <<= 1;
                res++;
            }
            out.println(res);
        } else {
            n -= tmp;
            out.println(res + (n + k - 1) / k);
        }
    }
}
