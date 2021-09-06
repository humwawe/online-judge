package codeforces.c742;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DExpressionEvaluationError {
    //     todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int s = in.nextInt();

        int n = in.nextInt();
        String ss = String.valueOf(s);
        int idx = 1;
        while (Integer.parseInt(ss.substring(0, idx)) < n) {
            idx++;
        }
        String last = ss.substring(idx);
        String tmp = "";
        for (int i = 0; i < last.length(); i++) {
            tmp += "0";
        }
        int sum = Integer.parseInt(ss.substring(0, idx));
        for (int i = 0; i < n - 1; i++) {
            out.print(1);
            out.print(tmp);
            out.print(" ");
            sum -= 1;
        }
        out.print(sum);
        out.print(last);
        out.println();
    }

}
