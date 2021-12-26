package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ABalanceTheBits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String s = in.nextString();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }
        if (cnt % 2 != 0 || s.charAt(0) != '1' || s.charAt(n - 1) != '1') {
            out.println("NO");
            return;
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int k = 0;
        boolean f = false;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (k * 2 < cnt) {
                    sb1.append('(');
                    sb2.append('(');
                } else {
                    sb1.append(')');
                    sb2.append(')');
                }
                k++;
            } else {
                if (!f) {
                    sb1.append('(');
                    sb2.append(')');
                } else {
                    sb1.append(')');
                    sb2.append('(');
                }
                f = !f;
            }
        }
        out.println("YES");
        out.println(sb1.toString());
        out.println(sb2.toString());
    }
}
