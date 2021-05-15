package code.jam.o2021.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class MinimumSort {
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = 100;
        for (int i = 1; i < n; i++) {
            out.println("M " + i + " " + n);
            out.flush();
            int t = in.nextInt();
            if (t != i) {
                out.println("S " + i + " " + t);
                out.flush();
                in.nextInt();
            }
        }
        out.println("D");
        out.flush();
        in.nextInt();
    }
}
