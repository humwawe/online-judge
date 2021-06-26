package codeforces.c728;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class APrettyPermutations {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        if (n % 2 == 0) {
            for (int i = 1; i <= n; i += 2) {
                out.print(i + 1 + " ");
                out.print(i + " ");
            }
        } else {
            for (int i = 1; i <= n - 3; i += 2) {
                out.print(i + 1 + " ");
                out.print(i + " ");
            }
            out.print(n + " ");
            out.print(n - 2 + " ");
            out.print(n - 1 + " ");
        }
        out.println();
    }
}
