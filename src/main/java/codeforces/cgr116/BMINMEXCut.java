package codeforces.cgr116;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMINMEXCut {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String s = in.nextString();
        int cnt = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == '0') {
                while (i < s.length() && s.charAt(i) == '0') {
                    i++;
                }
                cnt++;
            } else {
                i++;
            }
        }

        if (cnt >= 2) {
            out.println(2);
            return;
        }

        if (cnt == 1) {
            out.println(1);
            return;
        }

        if (cnt == 0) {
            if (s.charAt(0) == '1') {
                out.println(0);
            } else {
                out.println(1);
            }
        }
    }
}
