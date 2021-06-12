package acwing.contest.weekly.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        int inf = (int) 1e8;
        int res = inf;
        for (int num = 1; num <= 100; num++) {
            int i = 0;
            int cnt = 0;
            while (i < n) {
                if (a[i] == num) {
                    i++;
                } else {
                    cnt++;
                    i += k;
                }
            }
            res = Math.min(res, cnt);
        }
        out.println(res);
    }
}
