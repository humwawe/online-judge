package codeforces.c763;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CBalancedStoneHeaps {
    int n;
    int[] h;

    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        h = in.nextIntArray(n);
        int l = 1;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        out.println(l);
    }

    private boolean check(int mid) {
        int[] a = new int[n];
        if (h[n - 1] >= mid) {
            int d = (h[n - 1] - mid) / 3;
            a[n - 2] += d;
            a[n - 3] += 2 * d;
        } else {
            return false;
        }

        for (int i = n - 2; i >= 2; i--) {
            int d = h[i] / 3;
            if (d > 0) {
                a[i - 1] += d;
                a[i - 2] += 2 * d;
            }
        }
        if (a[0] + h[0] < mid) {
            return false;
        }
        if (a[1] + h[1] < mid) {
            return false;
        }
        for (int i = 2; i < n - 1; i++) {
            if (a[i] + h[i] % 3 < mid) {
                return false;
            }
        }
        return true;
    }
}
