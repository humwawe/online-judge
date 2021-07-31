package acwing.contest.weekly.c10;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        if (a % b == 0) {
            out.println(0);
            return;
        }
        out.println(b - a % b);
    }
}
