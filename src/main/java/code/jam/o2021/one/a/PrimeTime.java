package code.jam.o2021.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class PrimeTime {
    int n;
    int[] cnt = new int[500];
    int[] nums;
    long res;
    long N = (long) (5e17);
    int[] min = new int[500];
    int NUM = 35;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        nums = new int[n];
        res = 0;
        for (int i = 0; i < n; i++) {
            int p = in.nextInt();
            int n = in.nextInt();
            cnt[p] = n;
            nums[i] = p;
            min[i] = help(p);
        }
        dfs(n - 1, 0, 1, 0);
        out.printf("Case #%d: ", testNumber);
        out.println(res);
    }

    private int help(int p) {
        long tmp = 1;
        int r = 0;
        while (tmp < N) {
            tmp *= p;
            r++;
        }
        return r;
    }

    private void dfs(int u, long s, long m, int c) {
        if (s > N || m > N || c > NUM) {
            return;
        }
        if (u == -1) {
            if (s == m) {
                res = Math.max(res, s);
            }
            return;
        }
        for (int i = 0; i <= Math.min(min[u], cnt[nums[u]]); i++) {
            if (s > N || m > N || !helper(nums[u], i)) {
                continue;
            }
            dfs(u - 1, s + (long) nums[u] * (cnt[nums[u]] - i), m * (long) Math.pow(nums[u], i), c + i);
        }
    }

    private boolean helper(int num, int c) {
        long tmp = 1;
        for (int i = 0; i < c; i++) {
            if (tmp * num > N) {
                return false;
            }
            tmp *= num;
        }
        return true;
    }
}
