package codeforces.c730;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BCustomisingTheTrack {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += in.nextInt();
        }
        long b = sum % n;
        out.println((n - b) * b);
    }
}
