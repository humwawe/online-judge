package codeforces.c742;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CCarryingConundrum {
    char[] a;
    Integer[][][] memo;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String num = String.valueOf(n);
        int len = num.length();
        memo = new Integer[10][2][2];
        a = num.toCharArray();

        out.println(dfs(len - 1, 0, 0) - 2);

    }

    private int dfs(int u, int carry, int pcarry) {
        int cur = a[u] - '0';
        if (u == 0) {
            if (pcarry != 0) {
                return 0;
            }
            cur -= carry;
            if (cur % 2 == 0) {
                return cur + 1;
            } else {
                return (cur + 1) / 2 * 2;
            }
        }
        if (memo[u][carry][pcarry] != null) {
            return memo[u][carry][pcarry];
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i + j + carry) % 10 == cur) {
                    if (i + j + carry >= 10) {
                        res += dfs(u - 1, pcarry, 1);
                    } else {
                        res += dfs(u - 1, pcarry, 0);
                    }
                }
            }
        }
        return memo[u][carry][pcarry] = res;
    }
}

