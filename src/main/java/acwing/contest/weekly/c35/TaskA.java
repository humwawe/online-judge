package acwing.contest.weekly.c35;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String a = in.nextString().toLowerCase();
        String b = in.nextString().toLowerCase();
        int res = a.compareTo(b);
        if (res > 0) {
            out.println(1);
        } else if (res == 0) {
            out.println(0);
        } else {
            out.println(-1);
        }
    }
}
