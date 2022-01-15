package acwing.contest.weekly.c34;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < n; i++) {
            x += in.nextInt();
            y += in.nextInt();
            z += in.nextInt();
        }
        if (x == 0 && y == 0 && z == 0) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
