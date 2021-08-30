package codeforces.dds;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DTakeAGuess {
    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int last = 1;
        for (int i = 2; i <= n; i++) {
            out.println("and " + last + " " + i);
            out.flush();
            last = in.nextInt();
        }

    }
}
