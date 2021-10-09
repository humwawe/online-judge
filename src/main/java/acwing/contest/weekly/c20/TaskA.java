package acwing.contest.weekly.c20;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();
        int k = in.nextInt();
        int t1 = (a + c - 1) / c;
        int t2 = (b + d - 1) / d;
        if (t1 + t2 > k) {
            out.println(-1);
            return;
        }
        out.println(t1 + " " + t2);
    }
}
