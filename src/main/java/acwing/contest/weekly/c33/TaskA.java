package acwing.contest.weekly.c33;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '7' || s.charAt(i) == '4') {
                res++;
            }
        }
        if (res == 4 || res == 7) {
            out.println("YES");
        } else {
            out.println("NO");
        }

    }
}
