package codeforces.c726;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class E1EraseAndExtendEasyVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.nextString();
        char c = s.charAt(0);
        boolean f = false;
        int i;
        for (i = 1; i < n; i++) {
            if (s.charAt(i) == c) {
                f = true;
                break;
            } else if (s.charAt(i) > c) {
                break;
            }
        }
        int l = i;
        String tmp1 = s.substring(0, l);
        StringBuilder sb1 = new StringBuilder();
        while (sb1.length() < k) {
            sb1.append(tmp1);
        }
        if (f) {
            int j = 0;
            for (; l < n; l++) {
                if (s.charAt(l) <= c) {
                    j++;
                } else {
                    break;
                }
            }
        }

        String tmp2 = s.substring(0, l);
        StringBuilder sb2 = new StringBuilder();
        while (sb2.length() < k) {
            sb2.append(tmp2);
        }
        String s1 = sb1.substring(0, k);
        String s2 = sb2.substring(0, k);
        if (s1.compareTo(s2) > 0) {
            out.println(s2);
        } else {
            out.println(s1);
        }
    }
}
