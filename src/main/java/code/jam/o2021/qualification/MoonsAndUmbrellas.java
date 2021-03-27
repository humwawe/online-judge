package code.jam.o2021.qualification;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class MoonsAndUmbrellas {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int x = in.nextInt();
        int y = in.nextInt();
        String s = in.nextString();
        s = " " + s;
        int len = s.length();
        int[][] dp = new int[len + 1][2];
        int inf = (int) 1e8;
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], inf);
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            char c = s.charAt(i);
            char lastC = s.charAt(i - 1);
            if (c == 'C') {
                if (lastC == 'C') {
                    dp[i][0] = dp[i - 1][0];
                } else if (lastC == 'J') {
                    dp[i][0] = dp[i - 1][1] + y;
                } else if (lastC == '?') {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1] + y);
                } else {
                    dp[i][0] = 0;
                }
            } else if (c == 'J') {
                if (lastC == 'C') {
                    dp[i][1] = dp[i - 1][0] + x;
                } else if (lastC == 'J') {
                    dp[i][1] = dp[i - 1][1];
                } else if (lastC == '?') {
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + x);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][1]);
                } else {
                    dp[i][1] = 0;
                }
            } else {
                if (lastC == 'C') {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][0] + x;
                } else if (lastC == 'J') {
                    dp[i][0] = dp[i - 1][0] + y;
                    dp[i][1] = dp[i - 1][1];
                } else if (lastC == '?') {
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][0]);
                    dp[i][0] = Math.min(dp[i][0], dp[i - 1][1] + y);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][0] + x);
                    dp[i][1] = Math.min(dp[i][1], dp[i - 1][1]);
                } else {
                    dp[i][0] = 0;
                    dp[i][1] = 0;
                }
            }
        }
        out.printf("Case #%d: ", testNumber);
        out.println(Math.min(dp[len - 1][0], dp[len - 1][1]));
    }
}
