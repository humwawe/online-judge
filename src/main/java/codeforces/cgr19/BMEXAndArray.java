package codeforces.cgr19;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMEXAndArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = i; j < n; j++) {
                if (a[j] == 0) {
                    cnt++;
                }
                res += (j - i + 1) + cnt;
            }
        }
        out.println(res);
    }
}
