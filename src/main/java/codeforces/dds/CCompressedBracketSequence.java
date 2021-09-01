package codeforces.dds;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CCompressedBracketSequence {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long[] a = in.nextLongArray(n);
        long res = 0;

        for (int i = 0; i < n; i += 2) {
            long begin = a[i];
            long sum = 0;
            boolean first = true;
            for (int j = i + 1; j < n; j++) {
                if (j % 2 == 0) {
                    sum += a[j];
                } else {
                    if (a[j] < sum) {
                        sum -= a[j];
                    } else {
                        res += Math.min(begin, a[j] - sum);
                        if (first) {
                            first = false;
                        } else {
                            res++;
                        }
                        begin -= a[j] - sum;
                        sum = 0;
                        if (begin < 0) {
                            break;
                        }
                    }
                }
            }
        }
        out.println(res);
    }
}
