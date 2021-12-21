package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AMultiplesOfLength {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = in.nextIntArray(n);
        if (n == 1) {
            out.println("1 1");
            out.println(0);
            out.println("1 1");
            out.println(0);
            out.println("1 1");
            out.println(-a[0]);
        }
        out.println("1 1");
        out.println(-a[0]);
        out.println(1 + " " + n);
        out.print(0);
        for (int i = 1; i < n; i++) {
            out.print(" " + (long) -a[i] * n);
        }
        out.println();
        out.println(2 + " " + n);
        for (int i = 1; i < n; i++) {
            out.print((long) a[i] * (n - 1) + " ");
        }
    }
}
