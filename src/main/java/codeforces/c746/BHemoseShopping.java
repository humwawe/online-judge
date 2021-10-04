package codeforces.c746;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BHemoseShopping {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = a[i];
        }
        Arrays.sort(a);
        int l = x;
        int r = n - x - 1;
        for (int i = r + 1; i < l; i++) {
            if (!a[i].equals(b[i])) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }
}
