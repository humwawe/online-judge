package codeforces.c734;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CInterestingStory {
    int[][] cnt;
    int[] len;
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        cnt = new int[n][5];
        len = new int[n];
        for (int i = 0; i < n; i++) {
            String s = in.nextString();
            len[i] = s.length();
            for (int j = 0; j < s.length(); j++) {
                cnt[i][s.charAt(j) - 'a']++;
            }
        }
        int res = 0;
        for (int i = 0; i < 5; i++) {
            res = Math.max(res, helper(i));
        }
        out.println(res);
    }

    private int helper(int i) {
        int[] tmp = new int[n];
        for (int j = 0; j < n; j++) {
            tmp[j] = 2 * cnt[j][i] - len[j];
        }
        Arrays.sort(tmp);
        int sum = 0;
        int cnt = 0;
        for (int j = n - 1; j >= 0; j--) {
            sum += tmp[j];
            cnt++;
            if (sum <= 0) {
                return cnt - 1;
            }
        }
        return n;
    }
}
