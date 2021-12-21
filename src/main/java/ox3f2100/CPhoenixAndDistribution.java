package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class CPhoenixAndDistribution {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.nextString();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int[] cnt = new int[26];
        for (char c : chars) {
            cnt[c - 'a']++;
        }
        if (cnt[chars[0] - 'a'] < k) {
            out.println(chars[k - 1]);
            return;
        }
        boolean same = true;
        for (int i = k; i < n; i++) {
            if (chars[i] != chars[k]) {
                same = false;
                break;
            }
        }
        if (same) {
            out.print(chars[0]);
            int len = (n - 1) / k;
            for (int i = 0; i < len; i++) {
                out.print(chars[k]);
            }
        } else {
            out.print(chars[0]);
            for (int i = k; i < n; i++) {
                out.print(chars[i]);
            }
        }
        out.println();
    }
}
