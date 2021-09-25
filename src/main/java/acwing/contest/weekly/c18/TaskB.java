package acwing.contest.weekly.c18;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum += i * 12 - 12;
        }
        out.println(sum);
    }
}
