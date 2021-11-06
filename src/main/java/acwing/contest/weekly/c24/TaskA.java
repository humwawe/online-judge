package acwing.contest.weekly.c24;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int max = 0;
        int last = 0;
        for (int i = 0; i < n; i++) {
            last = in.nextInt();
            max = Math.max(max, last);
        }
        out.println(max ^ last);
    }
}
