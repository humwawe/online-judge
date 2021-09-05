package acwing.contest.weekly.c15;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskC {
    int N = 1005;
    int n, m;
    char[][] a = new char[N][N];
    int[][] fs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int res = 0;
    int inf = (int) 1e8;
    Integer[][] memo = new Integer[N][N];
    boolean[][] vis = new boolean[N][N];
    boolean first = false;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextCharacter();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'Q') {
                    first = true;
                    int tmp = dfs(i, j);
                    if (tmp >= inf) {
                        out.println("infinity");
                        return;
                    }
                    res = Math.max(res, tmp);
                }
            }
        }
        if (res == 0) {
            out.println("none");
        } else {
            out.println(res);
        }

    }

    private int dfs(int i, int j) {
        if (vis[i][j]) {
            return inf;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (a[i][j] == 'Q') {
            vis[i][j] = true;
        }
        int res = 0;
        for (int[] f : fs) {
            int x = i + f[0];
            int y = j + f[1];
            if (x >= 0 && x < n && y >= 0 && y < m) {
                if (check(i, j, x, y)) {
                    if (a[x][y] == 'R') {
                        res = Math.max(res, dfs(x, y) + 1);
                    } else {
                        res = Math.max(res, dfs(x, y));
                    }
                }
            }
        }
        if (a[i][j] == 'Q') {
            vis[i][j] = false;
        }
        return memo[i][j] = res;
    }

    private boolean check(int i, int j, int x, int y) {
        char c = a[i][j];
        char nc = a[x][y];
        if (c == 'Q') {
            return nc == 'W';
        } else if (c == 'W') {
            return nc == 'E';
        } else if (c == 'E') {
            return nc == 'R';
        } else if (c == 'R') {
            return nc == 'Q';
        }
        return false;
    }

}
