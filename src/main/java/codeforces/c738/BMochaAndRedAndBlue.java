package codeforces.c738;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.List;

public class BMochaAndRedAndBlue {
    int n;
    String s;
    List<Character> list;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        s = in.nextString();
        int[][] dp = new int[n + 1][2];
        int inf = (int) 1e8;
        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(dp[i], inf);
        }
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c == '?') {
                dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1]);
                dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i - 1][0]);
            } else if (c == 'R') {
                dp[i][0] = Math.min(dp[i - 1][0] + 1, dp[i - 1][1]);
            } else {
                dp[i][1] = Math.min(dp[i - 1][1] + 1, dp[i - 1][0]);
            }
        }
        StringBuilder sb = new StringBuilder();
        int last = 0;
        if (dp[n][0] <= dp[n][1]) {
            last = 0;
            sb.insert(0, 'R');
        } else {
            last = 1;
            sb.insert(0, 'B');
        }


        for (int i = n - 1; i >= 1; i--) {
            if (dp[i][last] + 1 == dp[i + 1][last]) {
                if (last == 0) {
                    sb.insert(0, 'R');
                    last = 0;
                } else {
                    sb.insert(0, 'B');
                    last = 1;
                }
            } else {
                if (last == 0) {
                    sb.insert(0, 'B');
                    last = 1;
                } else {
                    sb.insert(0, 'R');
                    last = 0;
                }
            }

        }
        out.println(sb.toString());
    }


}
