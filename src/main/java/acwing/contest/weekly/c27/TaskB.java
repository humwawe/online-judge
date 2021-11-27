package acwing.contest.weekly.c27;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
    long k;
    long n, m;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextLong();
        long l = 1;
        long r = n * m;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        out.println(l);
    }

    private boolean check(long mid) {
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.min(m, (mid / i));
        }
        return sum < k;
    }
}
