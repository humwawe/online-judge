package acwing.contest.weekly.c19;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String s = in.nextString();
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') {
                out.println("No");
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                int cnt = 0;
                if ((i - 1 >= 0 && s.charAt(i - 1) == '1')) {
                    cnt++;
                }
                if (i + 1 < n && s.charAt(i + 1) == '1') {
                    cnt++;
                }
                if (cnt == 0) {
                    out.println("No");
                    return;
                }
            }
        }
        out.println("Yes");
    }
}
