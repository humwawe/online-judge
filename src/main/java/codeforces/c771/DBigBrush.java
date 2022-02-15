package codeforces.c771;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.*;

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
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (check(i, j)) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int c = -1;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (a[x + i][y + j] != -1) {
                        c = a[x + i][y + j];
                    }
                }
            }
            if (c != -1) {
                res.add(new int[]{x, y, c});
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        a[x + i][y + j] = -1;
                    }
                }

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int nx = x + i;
                        int ny = y + j;
                        if (valid(nx, ny)) {
                            if (check(nx, ny)) {
                                queue.add(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != -1) {
                    out.println(-1);
                    return;
                }
            }
        }
        out.println(res.size());
        for (int i = res.size() - 1; i >= 0; i--) {
            int[] xyc = res.get(i);
            for (int j = 0; j < 2; j++) {
                xyc[j] += 1;
            }
            out.println(xyc);
        }

    }

    private boolean check(int x, int y) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (a[i + x][j + y] != -1) {
                    set.add(a[i + x][j + y]);
                }
            }
        }
        return set.size() == 1;
    }

    private boolean valid(int i, int j) {
        return i < n - 1 && j < m - 1 && i >= 0 && j >= 0;
    }

}
