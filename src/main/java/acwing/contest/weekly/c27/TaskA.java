package acwing.contest.weekly.c27;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    StringBuilder stringBuilder = new StringBuilder();

    {
        for (int i = 1; stringBuilder.length() < 1010; i++) {
            stringBuilder.append(i);
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        out.println(stringBuilder.charAt(n - 1));
    }
}
