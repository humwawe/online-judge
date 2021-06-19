package acwing.contest.weekly.c4;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int cnt1 = 0, cnt2 = 0;
        for (int i = 0; i < n; i++) {
            char c = in.nextCharacter();
            if (c == 'A') {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        if (cnt1 > cnt2) {
            out.println('A');
        } else if (cnt1 < cnt2) {
            out.println('B');
        } else {
            out.println("T");
        }
    }
}
