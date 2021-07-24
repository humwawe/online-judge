package acwing.contest.weekly.c8;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        if (a > b + c) {
            a = b + c;
        } else if (b > a + c) {
            b = a + c;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            char ch = in.nextCharacter();
            if (ch == '0') {
                res += a;
            } else {
                res += b;
            }
        }
        out.println(res);
    }
}
