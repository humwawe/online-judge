package codeforces.e114;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class BCombinatoricsHomework {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int[] a = new int[3];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextInt();
            max += a[i] - 1;
        }

        int m = in.nextInt();
        Arrays.sort(a);

        int min = a[2] - a[1] - a[0] - 1;

        if (m <= max && m >= min) {
            out.println("YES");
        } else {
            out.println("NO");
        }

    }
}
