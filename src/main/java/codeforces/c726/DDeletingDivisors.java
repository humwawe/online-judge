package codeforces.c726;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class DDeletingDivisors {
    int N = (int) (1e9 + 5);

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        boolean res = helper(n);
        if (res) {
            out.println("Alice");
        } else {
            out.println("Bob");
        }
    }

    private boolean helper(int n) {

        if (n == 1 || n == 2) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                if (!helper(n - n / i) || !helper(n - i)) {
                    return true;
                }
            }
        }
        return false;
    }
}
