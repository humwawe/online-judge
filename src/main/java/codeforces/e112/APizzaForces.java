package codeforces.e112;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APizzaForces {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long n = in.nextLong();
        if (n <= 6) {
            out.println(15);
            return;
        }
        if (n % 2 == 1) {
            n = n + 1;
        }
        out.println(n * 2 + n / 2);
    }
}
