package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class C2KLCMHardVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        n = n - k + 3;
        if (n % 2 == 1) {
            out.print(1 + " ");
            out.print(n / 2 + " ");
            out.print(n / 2 + " ");
        } else if (n % 4 == 0) {
            out.print(n / 2 + " ");
            out.print(n / 4 + " ");
            out.print(n / 4 + " ");
        } else {
            out.print(2 + " ");
            out.print(n / 2 - 1 + " ");
            out.print(n / 2 - 1 + " ");
        }

        for (int i = 3; i < k; i++) {
            out.print(1 + " ");
        }
        out.println();
    }
}
