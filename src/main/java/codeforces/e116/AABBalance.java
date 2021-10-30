package codeforces.e116;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AABBalance {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        char[] chars = s.toCharArray();
        if (check(chars, 'a', 'b') == check(chars, 'b', 'a')) {
            out.println(s);
        } else {
            for (int i = 0; i < s.length(); i++) {
                char c = chars[i];
                if (c == 'a') {
                    chars[i] = 'b';
                } else {
                    chars[i] = 'a';
                }
                if (check(chars, 'a', 'b') == check(chars, 'b', 'a')) {
                    out.println(chars);
                    return;
                }
                chars[i] = c;
            }
        }
    }

    private int check(char[] chars, char a, char b) {
        int cnt = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == a && chars[i + 1] == b) {
                cnt++;
            }
        }
        return cnt;
    }
}
