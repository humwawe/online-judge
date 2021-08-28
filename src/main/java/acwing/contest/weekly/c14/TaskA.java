package acwing.contest.weekly.c14;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int l1 = in.nextInt();
        int r1 = in.nextInt();
        int l2 = in.nextInt();
        int r2 = in.nextInt();
        if (l1 != l2) {
            out.println(l1 + " " + l2);
            return;
        }
        if (l1 != r2) {
            out.println(l1 + " " + r2);
            return;
        }
        if (r1 != r2) {
            out.println(r1 + " " + r2);
            return;
        }
    }
}
