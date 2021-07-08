package codeforces.c730;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class D1RPDAndRapSheetEasyVersion {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int x = 0;
        for (int i = 0; i < n; i++) {
            int y = i ^ x;
            out.println(y);
            out.flush();
            if (in.nextInt() == 1) {
                return;
            }
            x ^= y;
        }
    }
}