package acwing.contest.weekly.c31;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskA {
    int n;
    int res = 0;
    String s;
    int len;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        s = String.valueOf(n);
        len = s.length();
        for (int i = 1; i < len; i++) {
            res += helper(i);
        }
        if (s.charAt(0) == '1') {
            dfs(1, true);
        } else {
            res += helper(len);
        }
        out.println(res);
    }

    private void dfs(int i, boolean f) {
        if (i == len) {
            res++;
            return;
        }
        int lim;
        if (f) {
            lim = s.charAt(i) - '0';
        } else {
            lim = 1;
        }
        for (int j = 0; j <= Math.min(1, lim); j++) {
            dfs(i + 1, f & (s.charAt(i) - '0' == j));
        }
    }

    private int helper(int len) {
        int tmp = 1;
        for (int i = 0; i < len - 1; i++) {
            tmp *= 2;
        }
        return tmp;
    }
}
