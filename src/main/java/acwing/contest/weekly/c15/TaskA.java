package acwing.contest.weekly.c15;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        long a = in.nextInt();
        long b = in.nextInt();
        long k = in.nextInt();
        if (k % 2 == 0) {
            out.println(a * (k / 2) - b * (k / 2));
        } else {
            out.println(a * (k / 2 + 1) - b * (k / 2));
        }
    }
}
