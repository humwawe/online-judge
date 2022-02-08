package codeforces.c770;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AReverseAndConcatenate {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.nextString();
        if (k == 0) {
            out.println(1);
            return;
        }
        boolean f = helper(s);
        if (f) {
            out.println(1);
        } else {
            out.println(2);
        }
    }

    private boolean helper(String s) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
