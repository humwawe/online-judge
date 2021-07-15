package codeforces.e111;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class AFindTheArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int sum = in.nextInt();
        int x = 1;
        int res = 1;
        int tmp = 3;
        while (x < sum) {
            x += tmp;
            res++;
            tmp += 2;
        }
        out.println(res);
    }
}
