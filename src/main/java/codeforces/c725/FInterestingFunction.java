package codeforces.c725;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class FInterestingFunction {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int l = in.nextInt();
        int r = in.nextInt();
        out.println(helper(r) - helper(l));
    }

    private int helper(int v) {
        int tmp = 0;
        int res = 0;
        int tmp2 = 1;
        for (int i = 0; i < 10; i++) {
            tmp = tmp * 10 + 9;
            tmp2 *= 10;
            int a = v / tmp2;
            int b = v % tmp2;
            res += a;
            if (a == 0) {
                break;
            }
            if (b == tmp) {
                res += 1;
            }

        }
        return v + res;
    }
}
