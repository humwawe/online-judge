package codeforces.e114;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class ARegularBracketSequences {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        if (n == 1) {
            out.println("()");
            return;
        }
        for (int i = 0; i < n; i++) {
            out.print("()");
        }
        out.println();
        for (int i = 0; i < n; i++) {
            out.print("(");
        }
        for (int i = 0; i < n; i++) {
            out.print(")");
        }
        out.println();
        String s1 = "()";
        String s2 = "(())";
        StringBuilder tmp = new StringBuilder();
        for (int j = 0; j < n - 2; j++) {
            tmp.append(s1);
        }
        for (int i = 0; i < n - 2; i++) {
            StringBuilder sb = new StringBuilder(tmp);
            sb.insert(i * 2, s2);
            out.println(sb.toString());
        }
    }
}
