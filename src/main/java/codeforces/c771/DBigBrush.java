package codeforces.c771;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DBigBrush {
    int n, m;
    int[][] a;
    boolean[][] vis;

    // todo
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
        int x = -1;
        int y = -1;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (check(i, j)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }
        if (x == -1) {
            out.println(-1);
            return;
        }
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                queue.add(new int[]{x + i, y + j});
                vis[x + i][y + j] = true;
            }
        }
        res.add(new int[]{x, y, a[x][y]});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (valid(poll[0], poll[1]) && !vis[poll[0]][poll[1]]) {

            }
        }

    }

    private boolean check(int i, int j) {
        if (valid(i, j)) {
            return a[i][j] == a[i + 1][j] && a[i][j] == a[i][j + 1] && a[i][j] == a[i + 1][j + 1];
        }
        return false;
    }

    private boolean valid(int i, int j) {
        return i < n - 1 && j < m - 1 && i >= 0 && j >= 0;
    }

}
