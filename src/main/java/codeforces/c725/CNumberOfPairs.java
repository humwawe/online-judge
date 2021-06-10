package codeforces.c725;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CNumberOfPairs {
    int n, l, r;
    int[] a;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        l = in.nextInt();
        r = in.nextInt();
        a = in.nextIntArray(n);
        Arrays.sort(a);
        long res = helper(r) - helper(l - 1);
        out.println(res);
    }

    private long helper(int v) {
        long res = 0;
        for (int i = 1; i < n; i++) {
            int tmp = v - a[i];
            int l = 0;
            int r = i - 1;
            if (a[r] <= tmp) {
                res += r + 1;
                continue;
            }
            while (l < r) {
                int mid = l + r >> 1;
                if (a[mid] > tmp) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            res += l;
        }
        return res;
    }
}
