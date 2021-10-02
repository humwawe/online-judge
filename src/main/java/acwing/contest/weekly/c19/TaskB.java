package acwing.contest.weekly.c19;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
    int[] a;
    int n, w;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        w = in.nextInt();
        a = in.nextIntArray(n);
        int l = 0;
        int r = w;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int min = l;
        if (!check(min)) {
            out.println(0);
            return;
        }
        l = 0;
        r = w;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check2(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int max = l;
        if (!check2(max)) {
            out.println(0);
            return;
        }
        if (min > max) {
            out.println(0);
        } else {
            out.println(max - min + 1);
        }

    }

    private boolean check2(int mid) {
        int t = mid;
        for (int i = 0; i < n; i++) {
            t += a[i];
            if (t > w) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int mid) {
        int t = mid;
        for (int i = 0; i < n; i++) {
            t += a[i];
            if (t < 0) {
                return false;
            }
        }
        return true;
    }
}
