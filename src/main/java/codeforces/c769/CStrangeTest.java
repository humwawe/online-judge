package codeforces.c769;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CStrangeTest {
    int a, b;
    int inf = (int) 1e9;
    int N = 20;
    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        a = in.nextInt();
        b = in.nextInt();
        out.println(Math.min(dfs(a, b, 0), b - a));
    }

    private int dfs(int a, int b, int i) {
        if (i == 30) {
            if (a == b) {
                return 0;
            } else {
                if ((a | b) == b) {
                    return 1;
                }
                return inf;
            }
        }

        int res = inf;
        if (((a >> i) & 1) != ((b >> i) & 1)) {
            res = Math.min(res, dfs(a + (1 << i), b, i + 1) + (1 << i));
            res = Math.min(res, dfs(a, b + (1 << i), i + 1) + (1 << i));
            res = Math.min(res, dfs(a | b, b, i + 1) + 1);
            return res;
        } else {
            return dfs(a, b, i + 1);
        }
    }
}
