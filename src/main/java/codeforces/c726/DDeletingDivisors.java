package codeforces.c726;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DDeletingDivisors {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        if (n % 2 == 1) {
            out.println("Bob");
            return;
        }
        int cnt = 0;
        while (n % 2 == 0) {
            cnt++;
            n /= 2;
        }
        if (n > 1) {
            out.println("Alice");
        } else if (cnt % 2 == 0) {
            out.println("Alice");
        } else {
            out.println("Bob");
        }
    }
}
