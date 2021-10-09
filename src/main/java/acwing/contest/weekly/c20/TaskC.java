package acwing.contest.weekly.c20;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class TaskC {
    int n;
    int[] c;
    int[] a = new int[5005];
    int len = 0;
    int inf = (int) 1e8;
    int[][] memo;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        c = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            c[i] = in.nextInt();
            if (c[i] != c[i - 1]) {
                a[len++] = c[i];
            }
        }
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(memo[i], -1);
        }
        out.println(helper(0, len - 1));
    }

    private int helper(int l, int r) {
        if (l == r) {
            return 0;
        }
        if (l == r - 1) {
            return 1;
        }
        if (memo[l][r] != -1) {
            return memo[l][r];
        }
        int res = inf;
        if (a[l] == a[r]) {
            res = Math.min(res, helper(l + 1, r - 1) + 1);
        } else {
            res = Math.min(res, helper(l + 1, r) + 1);
            res = Math.min(res, helper(l, r - 1) + 1);
        }
        return memo[l][r] = res;
    }
}
