package acwing.contest.weekly.c3;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    // 可以考虑横和竖的最大距离相加
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int r = in.nextInt();
        int c = in.nextInt();
        int t = Math.abs(n - r) + Math.abs(m - c);
        t = Math.max(t, Math.abs(1 - r) + Math.abs(1 - c));
        t = Math.max(t, Math.abs(1 - r) + Math.abs(m - c));
        t = Math.max(t, Math.abs(n - r) + Math.abs(1 - c));
        out.println(t);
    }
}
