package acwing.contest.weekly.c24;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int x1 = in.nextCharacter() - 'a';
        int y1 = in.nextCharacter() - '1';
        int x2 = in.nextCharacter() - 'a';
        int y2 = in.nextCharacter() - '1';

        boolean[][] vis = new boolean[8][8];
        vis[x1][y1] = true;
        vis[x2][y2] = true;
        int[][] fs = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        int x = x1;
        int y = y1;
        for (int[] f : fs) {
            for (int i = 1; ; i++) {
                int nx = x + f[0] * i;
                int ny = y + f[1] * i;
                if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                    vis[nx][ny] = true;
                } else {
                    break;
                }
            }
        }

        fs = new int[][]{{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        x = x2;
        y = y2;
        for (int[] f : fs) {
            int nx = x + f[0];
            int ny = y + f[1];
            if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8) {
                vis[nx][ny] = true;
            }
        }
        int res = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (vis[i][j]) {
                    continue;
                }
                boolean flag = true;
                for (int[] f : fs) {
                    int nx = i + f[0];
                    int ny = j + f[1];
                    if (nx == x1 && ny == y1) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    res++;
                }
            }
        }
        out.println(res);

    }
}
