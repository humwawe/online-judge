package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class GSpecialPermutation {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        if (n < 4) {
            out.println(-1);
            return;
        }
        for (int i = n; i > 0; i--) {
            if (i % 2 == 1) {
                out.print(i + " ");
            }
        }
        out.print("4 2 ");
        for (int i = 6; i <= n; i++) {
            if (i % 2 == 0) {
                out.print(i + " ");
            }
        }
        out.println();
    }
}
