package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ALongBeautifulInteger {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        String s = in.nextString();
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < k; i++) {
            int j = i + k;
            while (j < n) {
                sb.setCharAt(j, s.charAt(i));
                j += k;
            }
        }
        out.println(n);
        if (sb.toString().compareTo(s) >= 0) {
            out.println(sb.toString());
            return;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (sb.charAt(i) < '9') {
                sb.setCharAt(i, (char) (sb.charAt(i) + 1));
                int j = i + k;
                while (j < n) {
                    sb.setCharAt(j, sb.charAt(i));
                    j += k;
                }
                for (int l = i + 1; l < k; l++) {
                    j = l;
                    while (j < n) {
                        sb.setCharAt(j, '0');
                        j += k;
                    }
                }
                out.println(sb.toString());
                return;
            }
        }

    }
}
