package best.coder.o2021.two;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Task1002 {
    int n, m;
    int N = 3005;
    int mod = (int) (1e9 + 7);
    Integer[][] memo = new Integer[N][N];

    {
        dfs(N - 1, N - 1, 0);
    }

    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
//        out.println(memo[n][m]);
        out.println(dfs1(n, m, 0) + dfs1(n, m, 1));
    }

    private int dfs1(int n, int m, int type) {
        if (n == 0 || m == 0) {
            return 1;
        }
        int res = 0;
        if (type == 0) {
            res += dfs1(n - 1, m, 0);
            res += m * dfs1(n, m - 1, 1);
        } else if (type == 1) {
            res += dfs1(n, m - 1, 1);
            res += n * dfs1(n - 1, m, 0);
        }
        return res;
    }

    private int dfs(int n, int m, int type) {
        if (memo[n][m] != null) {
            return memo[n][m];
        }
        if (m == 0) {
            if (type == 1) {
                return 1;
            } else if (type == 2) {
                return 0;
            } else if (type == 3) {
                return 0;
            }
        }
        if (type == 0) {
            return memo[n][m] = dfs(n, m, 1) + dfs(n, m, 2) + dfs(n, m, 3);
        } else if (type == 1) {
            return memo[n][m] = dfs(n, m - 1, 1);
        } else if (type == 2) {
            return memo[n][m] = 2 * dfs(n, m - 1, 1) + dfs(n, m - 1, 2);
        } else {
            return memo[n][m] = dfs(n, m - 1, 2) + dfs(n, m - 1, 3);
        }
    }
}
