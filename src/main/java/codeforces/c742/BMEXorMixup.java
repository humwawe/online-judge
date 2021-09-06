package codeforces.c742;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class BMEXorMixup {
    int N = (int) (3e5 + 5);
    int[] num = new int[N];

    {
        for (int i = 1; i < N; i++) {
            num[i] = num[i - 1] ^ i;
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        if (num[a - 1] == b) {
            out.println(a);
        } else if ((num[a - 1] ^ b) == a) {
            out.println(a + 2);
        } else {
            out.println(a + 1);
        }
    }
}
