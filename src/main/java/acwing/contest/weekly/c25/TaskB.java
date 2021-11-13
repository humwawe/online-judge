package acwing.contest.weekly.c25;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
    int N = 405;
    int[][] dist1 = new int[N][N];
    int[][] dist2 = new int[N][N];
    int n;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        int m = in.nextInt();
        init();
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            dist1[a][b] = 1;
            dist1[b][a] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (dist1[i][j] != 1) {
                    dist2[i][j] = 1;
                    dist2[j][i] = 1;
                }
            }
        }
        floyd(dist1);
        floyd(dist2);
        if (dist1[1][n] == 0x3f3f3f3f || dist2[1][n] == 0x3f3f3f3f) {
            out.println(-1);
        } else {
            out.println(Math.max(dist1[1][n], dist2[1][n]));
        }

    }

    void floyd(int[][] dist) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    void init() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    dist1[i][j] = 0;
                    dist2[i][j] = 0;
                } else {
                    dist1[i][j] = 0x3f3f3f3f;
                    dist2[i][j] = 0x3f3f3f3f;
                }
            }
        }
    }
}
