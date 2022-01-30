package codeforces.c769;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AABC {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String s = in.nextString();
        if (s.equals("0") || s.equals("1") || s.equals("01") || s.equals("10")) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
