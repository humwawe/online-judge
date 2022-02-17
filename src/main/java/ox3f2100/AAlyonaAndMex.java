package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AAlyonaAndMex {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int res = n;
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            res = Math.min(res, b - a);
        }
        out.println(res + 1);
        for (int i = 0; i < n; i++) {
            out.print(i % (res + 1) + " ");
        }
        out.println();
    }
}
