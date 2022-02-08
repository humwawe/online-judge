package codeforces.c770;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BFortuneTelling {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] a = new int[n];
        int cnt = 0;
        if (x % 2 != 0) {
            cnt++;
        }
        if (y % 2 != 0) {
            cnt++;
        }
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] % 2 != 0) {
                cnt++;
            }
        }
        if (cnt % 2 != 0) {
            out.println("Bob");
        } else {
            out.println("Alice");
        }
    }
}
