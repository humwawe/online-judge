package acwing.contest.weekly.c7;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int h = in.nextInt();
        int m = in.nextInt();
        out.println(24 * 60 - h * 60 - m);
    }
}
