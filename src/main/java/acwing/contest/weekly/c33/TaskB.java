package acwing.contest.weekly.c33;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        int len = s.length();
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                if (cnt > 0) {
                    res += 2;
                    cnt--;
                }
            }
        }
        out.println(res);
    }
}
